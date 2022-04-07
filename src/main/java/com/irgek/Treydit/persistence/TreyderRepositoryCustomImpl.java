package com.irgek.Treydit.persistence;

import com.irgek.Treydit.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class TreyderRepositoryCustomImpl extends QuerydslRepositorySupport implements TreyderRepositoryCustom {

    private EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    public TreyderRepositoryCustomImpl( EntityManager entityManager, JdbcTemplate jdbcTemplate) {
        super(Treyder.class);
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Treyder addTreyder(Treyder treyder) {
        entityManager.persist(treyder);
        return treyder;
    }

    @Override
    public Treyder getByUsername(String username) {
        return jdbcTemplate.queryForObject("Select * from Treyder where username = " + username, Treyder.class);
    }

    @Override
    public List<Treyder> getTreyderbyFirstname(String firstname) {
        List<Treyder> treyders = jdbcTemplate.query("Select * from Treyder where firstname = " + firstname, new RowMapper<Treyder>() {
            @Override
            public Treyder mapRow(ResultSet rs, int rowNum) throws SQLException {
                Treyder treyder = new Treyder();
                treyder.setFirstname((String) rs.getObject("Firstname"));
                treyder.setLastname((String) rs.getObject("Lastname"));
                //treyder.setUsername(rs.getString("Username"));
                treyder.setGender((Gender) rs.getObject("Gender"));
                treyder.setBirthDate(rs.getDate("LocalDate").toLocalDate());
                treyder.setEmail(rs.getString("Email"));
                treyder.setAddress((Address) rs.getObject("Address"));

                return treyder;
            }
        });
        return treyders;
    }
}
