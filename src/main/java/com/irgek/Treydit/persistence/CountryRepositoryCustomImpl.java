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
public class CountryRepositoryCustomImpl extends QuerydslRepositorySupport implements CountryRepositoryCustom {

    private EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    public CountryRepositoryCustomImpl(EntityManager entityManager, JdbcTemplate jdbcTemplate) {
        super(Country.class);
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Country addCountry(Country country) {
        entityManager.persist(country);
        return country;
    }

    @Override
    public Country getByName(String name) {
        return jdbcTemplate.queryForObject("Select * from Country where name = " + name, Country.class);
    }

    @Override
    public List<Country> getCountries() {
        List<Country> countries = jdbcTemplate.query("Select * from Country ", new RowMapper<Country>() {
            @Override
            public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
                Country country = new Country();
                country.setName(rs.getString("Name"));
                country.setIso2Code(rs.getString("Iso2Code"));
                return country;
            }
        });
        return countries;
    }
}
