package vn.edu.iuh.fit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.CandidateSkill;
import vn.edu.iuh.fit.pks.CandidateSkillId;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CandidateSkillRepository extends DataRepository<CandidateSkill, CandidateSkillId>{
    private JdbcTemplate template;
    private DataSource dataSource;
    private RowMapper<CandidateSkill> rowMapper;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SkillRepository skillRepository;

    public CandidateSkillRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(this.dataSource);
        rowMapper = new RowMapper<CandidateSkill>() {
            @Override
            public CandidateSkill mapRow(ResultSet rs, int rowNum) throws SQLException {
                CandidateSkill candidateSkill = new CandidateSkill();
                candidateSkill.setCandidate(candidateRepository.findOne(rs.getInt(1)));
                candidateSkill.setSkill(skillRepository.findOne(rs.getInt(2)));
                candidateSkill.setLevel(rs.getInt(3));
                return candidateSkill;
            }
        };
    }
    @Override
    public CandidateSkill findOne(CandidateSkillId candidateSkillId) {
        String query = "select * from candidate_skill where candidate_id = ? and skill_id = ?";
        return template.queryForObject(query, rowMapper, candidateSkillId.getCandidate().getCandidateID(), candidateSkillId.getSkill().getSkillId());
    }

    @Override
    public List<CandidateSkill> getAll() {
        String query = "select * from candidate_skill";
        return template.query(query, rowMapper);
    }

    @Override
    public boolean insert(CandidateSkill candidateSkill) {
        String insert = "insert into candidate_skill(candidate_id, skill_id, level) values(?,?,?)";
        int n = template.update(insert, candidateSkill.getCandidate().getCandidateID(),
                candidateSkill.getSkill().getSkillId(), candidateSkill.getLevel());
        return n != 0;
    }

    @Override
    public boolean delete(CandidateSkillId candidateSkillId) {
        String delete = "delete FROM candidate_skill where candidate_id = ? and skill_id = ?";
        int n = template.update(delete, candidateSkillId.getCandidate().getCandidateID(), candidateSkillId.getSkill().getSkillId());
        return n != 0;
    }

    @Override
    public boolean update(CandidateSkill candidateSkill) {
        String update = "update candidate_skill set level = ? where candidate_id = ? and skill_id = ?";
        int n = template.update(update, candidateSkill.getLevel(), candidateSkill.getCandidate().getCandidateID(), candidateSkill.getSkill().getSkillId());
        return n != 0;
    }
}
