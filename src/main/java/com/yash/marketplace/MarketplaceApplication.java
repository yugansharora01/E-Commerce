package com.yash.marketplace;

import com.yash.marketplace.Repository.ItemRepository;
import com.yash.marketplace.models.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarketplaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(ItemRepository itemRepository){
//		return args -> {
//			Item item = new Item("1","some name","some description",20.3,"image url",2);
//			itemRepository.create(item);
//		};
//	}

}
