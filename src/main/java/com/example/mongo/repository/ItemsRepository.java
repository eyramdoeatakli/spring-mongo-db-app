package com.example.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mongo.model.GroceryItem;

@Repository
public interface ItemsRepository extends MongoRepository<GroceryItem, String>{
	 
	     @Query("{name:'?0'}")
	     GroceryItem findItemByNameNativeQuery(String name); 
		 GroceryItem findByName(String name);

	    // @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	  //  List<GroceryItem> findAll(String category);
	     
	     public long count();

}
