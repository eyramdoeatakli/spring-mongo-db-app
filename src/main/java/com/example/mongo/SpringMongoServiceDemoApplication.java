package com.example.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.mongo.model.GroceryItem;
import com.example.mongo.repository.ItemsRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableMongoRepositories
@Slf4j
public class SpringMongoServiceDemoApplication implements CommandLineRunner {
	
	    @Autowired
	    ItemsRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoServiceDemoApplication.class, args);
	}
	
	void createGroceryItems() {
		System.out.println("Data creation started...");
		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
		groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
		groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		System.out.println("Data creation complete...");
	}


	void findItemByName() {
		GroceryItem item= groceryItemRepo.findByName("Dried Whole Red Chilli");
		//GroceryItem item= groceryItemRepo.findItemByNameNativeQuery("Dried Whole Red Chilli");
		
		log.info("Found Items {}",item);

	}
	
	void findAllItems() {
		List<GroceryItem> item= groceryItemRepo.findAll();
		item.forEach(i->log.info("All  Items {}",i));

	}

	@Override
	public void run(String... args) throws Exception {
		createGroceryItems();
	    findItemByName();
		findAllItems();
	}

}
