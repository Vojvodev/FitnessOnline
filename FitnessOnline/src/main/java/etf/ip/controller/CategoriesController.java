package etf.ip.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.model.Categories;
import etf.ip.model.Subscriptions;
import etf.ip.repository.CategoriesRepository;
import etf.ip.repository.SubscriptionsRepository;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class CategoriesController {
	@Autowired
	private CategoriesRepository categoriesRep;
	
	@Autowired
	private SubscriptionsRepository subRep;

	
	
	// get all categories
	@GetMapping("/categories")
	public List<Categories> getAllCategories(Pageable pageable){
		return categoriesRep.findAll(pageable).getContent();
	}
	
	
	@PostMapping("/add/subscription")
	public ResponseEntity<?> addSubscription(@RequestParam String categoryName, @RequestParam String username){
		
		Subscriptions s = new Subscriptions(categoryName, username);
		subRep.save(s);
		
		return ResponseEntity.ok("Subscription added successfully!");
	}
	
}
