package com.yash.marketplace.Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.marketplace.Repository.jdbcItemRepository;
import com.yash.marketplace.models.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ItemJsonLoader implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ItemJsonLoader.class);
    private final jdbcItemRepository jdbcItemRepository;
    private final ObjectMapper objectMapper;

    public ItemJsonLoader(jdbcItemRepository jdbcItemRepository, ObjectMapper objectMapper) {
        this.jdbcItemRepository = jdbcItemRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (jdbcItemRepository.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data/data.json")) {
                if (inputStream == null) {
                    throw new IOException("Resource not found: /data/data.json");
                }
                Items allItems = objectMapper.readValue(inputStream, Items.class);
                log.info("Reading json and adding {} items", allItems.items().size());
                jdbcItemRepository.saveAll(allItems.items());
            } catch (IOException e) {
                throw new RuntimeException("Data not loaded", e);
            }
        } else {
            log.info("itemRepository not empty");
        }
    }
}
