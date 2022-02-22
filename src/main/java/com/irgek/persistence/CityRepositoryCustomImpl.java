package com.irgek.persistence;

import com.irgek.domain.City;
import com.irgek.domain.Country;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CityRepositoryCustomImpl extends QuerydslRepositorySupport implements  CityRepositoryCustom {

   private EntityManager entityManager;
   private final JdbcTemplate jdbcTemplate;

    public CityRepositoryCustomImpl(EntityManager entityManager, JdbcTemplate jdbcTemplate) {
        super(City.class);
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public City addCity(City city) {
        entityManager.persist(city);
        return city;
    }

    @Override
    public City getByName(String name) {
        return jdbcTemplate.queryForObject("Select * from City where name = " + name,City.class);
    }

    @Override
    public List<City> getCitiesbyCountry(Country country) {
        List<City> cities = jdbcTemplate.query("Select * from City where country = " + country, new RowMapper<City>() {
            @Override
            public City mapRow(ResultSet rs, int rowNum) throws SQLException {
                City city = new City();
                city.setName(rs.getString("Name"));
                city.setCountry((Country) rs.getObject("Country"));
                return city;
            }
        });
        return cities;
    }
}
