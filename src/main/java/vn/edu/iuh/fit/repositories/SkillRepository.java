package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Skill;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SkillRepository extends DataRepository<Skill, Integer>{

    private JdbcTemplate template;
    private DataSource dataSource;
    private RowMapper<Skill> rowMapper;

    public SkillRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(this.dataSource);
        rowMapper = new RowMapper<Skill>() {
            @Override
            public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
                Skill skill = new Skill();
                skill.setSkillId(rs.getInt(1));
                skill.setSkillName(rs.getString(2));
                return skill;
            }
        };
    }

    @Override
    public Skill findOne(Integer id) {
        String query = "select * from skill where skill_id = ?";
        return template.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Skill> getAll() {
        String query = "select * from skill";
        return template.query(query, rowMapper);
    }

    @Override
    public boolean insert(Skill skill) {
        String insert = "insert into skill(skill_id,skill_name) values(?,?)";
        int n = template.update(insert, skill.getSkillId(),skill.getSkillName());
        return n != 0;
    }

    @Override
    public boolean delete(Integer id) {
        String delete = "delete FROM skill where skill_id = ?";
        int n = template.update(delete, id);
        return n != 0;
    }

    @Override
    public boolean update(Skill skill) {
        String update = "update skill set skill_name = ? where skill_id = ?";
        int n = template.update(update, skill.getSkillName(), skill.getSkillId());
        return n != 0;
    }
}
