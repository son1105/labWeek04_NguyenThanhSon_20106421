package vn.edu.iuh.fit.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.entities.Candidate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CandidateRepository extends DataRepository<Candidate, Integer> {

    private JdbcTemplate template;
    private DataSource dataSource;
    private RowMapper<Candidate> rowMapper;

    public CandidateRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new JdbcTemplate(this.dataSource);
        rowMapper = new RowMapper<Candidate>() {
            @Override
            public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
                Candidate candidate = new Candidate();
                candidate.setCandidateID(rs.getInt(1));
                candidate.setFullName(rs.getString(2));
                candidate.setEmail(rs.getString(3));
                candidate.setPhone(rs.getString(4));
                candidate.setAddress(rs.getString(5));
                return candidate;
            }
        };
    }

    @Override
    public Candidate findOne(Integer id) {
        String query = "select * from candidate where can_id = ?";
        return template.queryForObject(query, rowMapper, id);
    }

    @Override
    public List<Candidate> getAll() {
        String query = "select * from candidate";
        return template.query(query, rowMapper);
    }

    @Override
    public boolean insert(Candidate candidate) {
        String insert = "insert into candidate(can_id, full_name, email, phone, address) values(?,?,?,?,?)";
        int n = template.update(insert, candidate.getCandidateID(), candidate.getFullName(),candidate.getEmail(),candidate.getPhone(),candidate.getAddress());
        return n != 0;
    }

    @Override
    public boolean delete(Integer id) {
        String delete = "delete FROM candidate where can_id = ?";
        int n = template.update(delete, id);
        return n != 0;
    }

    @Override
    public boolean update(Candidate candidate) {
        String update = "update candidate set full_name = ? , email = ? , phone= ?,address = ? where can_id = ?";
        int n = template.update(update, candidate.getFullName(),candidate.getEmail(),candidate.getPhone(),candidate.getAddress(),candidate.getCandidateID());
        return n != 0;
    }
}
