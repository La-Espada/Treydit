package com.irgek.persistence;

import com.irgek.domain.Condition;
import com.irgek.domain.Item;
import com.irgek.domain.Treyder;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemRepositoryCustomImpl extends QuerydslRepositorySupport implements ItemRepositoryCustom {

    private EntityManager entityManager;
    private final JdbcTemplate jdbcTemplate;

    public ItemRepositoryCustomImpl(EntityManager entityManager, JdbcTemplate jdbcTemplate) {
        super(Item.class);
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Item addItem(Item item) {
        entityManager.persist(item);
        return item;
    }

    @Override
    public Item getByName(String itemName) {
        return jdbcTemplate.queryForObject("Select * from Item where name = " + itemName, Item.class);
    }

    @Override
    public List<Item> getItemsbyTreyder(Treyder treyder) {
        List<Item> items = jdbcTemplate.query("Select * from Item where treyder = " + treyder, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item item = new Item();
                item.setName(rs.getString("Name"));
                item.setItemCondition((Condition) rs.getObject("Condition"));
                item.setCost(rs.getDouble("Cost"));
                item.setDescription(rs.getString("Description"));

                return item;
            }
        });
        return items;
    }
}
