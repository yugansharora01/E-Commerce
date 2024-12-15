package com.yash.marketplace.Repository;

import com.yash.marketplace.models.Item;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class jdbcItemRepository {
    private static final Logger log = LoggerFactory.getLogger(jdbcItemRepository.class);
    private final JdbcClient jdbcClient;

    public jdbcItemRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Item> findAll() {
        return jdbcClient.sql("SELECT * FROM item")
                .query(Item.class)
                .list();
    }

    public Optional<Item> findById(Integer id) {
        return jdbcClient.sql("SELECT * FROM item WHERE id = :id")
                .param("id", id)
                .query(Item.class)
                .optional();
    }

    public void create(@NotNull Item item) {
        int updated = jdbcClient.sql("INSERT INTO item(name, description, price, img_url, quantity, created_on) VALUES (?,?,?,?,?,?)")
                .params(List.of(item.getName(), item.getDescription(), item.getPrice(), item.getImgUrl(), item.getQuantity(), item.getCreatedOn()))
                .update();
        Assert.state(updated == 1, "Failed to create item " + item.getName());
    }

    public void update(@NotNull Item item) {
        int updated = jdbcClient.sql("UPDATE item SET name = ?, description = ?, price = ?, img_url = ?, quantity = ?, bought_on = ?, listed_on = ? WHERE id = :id")
                .params(List.of(item.getName(), item.getDescription(), item.getPrice(), item.getImgUrl(), item.getQuantity(), item.getBoughtOn(), item.getListedOn(), item.getId()))
                .update();
        Assert.state(updated == 1, "Failed to update item " + item.getName());
    }

    public void delete(Integer id) {
        int deleted = jdbcClient.sql("DELETE FROM item WHERE id = :id")
                .param("id", id)
                .update();
        Assert.state(deleted == 1, "Failed to delete " + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT COUNT(*) FROM item").query(Integer.class).single();
    }

    public void saveAll(List<Item> items) {
        items.forEach(this::create);
    }
}
