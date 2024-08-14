package com.shoppingCenter.inventory_service;

import com.shoppingCenter.inventory_service.dto.InventoryResponse;
import com.shoppingCenter.inventory_service.entity.Inventory;
import com.shoppingCenter.inventory_service.repository.InventoryRepository;
import com.shoppingCenter.inventory_service.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("i_phone15");
			inventory.setQuantity(20);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("i_phone15_black");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
