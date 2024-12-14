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
public class ItemRepository {
    private static final Logger log = LoggerFactory.getLogger(ItemRepository.class);
    private final JdbcClient jdbcClient;

    public ItemRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Item> findAll(){
        return jdbcClient.sql("SELECT * FROM item")
                .query(Item.class)
                .list();
    }

    public Optional<Item> findById(Integer id){
        return jdbcClient.sql("SELECT * FROM ITEM WHERE id = :id")
                .param("id",id)
                .query(Item.class)
                .optional();
    }

    public void create(@NotNull Item item){
        int updated = jdbcClient.sql("INSERT INTO ITEM(`id, name, description, price, imgUrl, quantity,createdOn`) values(?,?,?,?,?,?,?")
                .params(List.of(item.getId(),item.getName(),item.getDescription(),item.getPrice(),item.getImgUrl(),item.getQuantity(),item.getCreatedOn()))
                .update();
        Assert.state(updated == 1,"Failed to create item " + item.getName());
    }

    public void update(@NotNull Item item){
        int updated = jdbcClient.sql("UPDATE ITEM SET name = ?, description = ?, price = ?, imgUrl = ?, quantity = ?,boughtOn = ?,listedOn = ? WHERE id = :id")
                .params(List.of(item.getName(),item.getDescription(),item.getPrice(),item.getImgUrl(),item.getQuantity(),item.getBoughtOn(), item.getListedOn(),item.getId()))
                .update();
        Assert.state(updated == 1,"Failed to update item " + item.getName());
    }

    public void delete(Integer id){
        int deleted = jdbcClient.sql("DELETE FROM ITEM WHERE id = :id")
                .param("id",id)
                .update();
        Assert.state(deleted == 1,"Failed to delete " + id);
    }
}
