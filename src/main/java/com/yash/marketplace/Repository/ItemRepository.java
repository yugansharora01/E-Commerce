package com.yash.marketplace.Repository;

import com.yash.marketplace.models.Item;
import org.springframework.data.repository.ListCrudRepository;

public interface ItemRepository extends ListCrudRepository<Item,Integer> {
}
