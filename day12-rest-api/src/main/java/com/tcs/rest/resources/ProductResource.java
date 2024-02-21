package com.tcs.rest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.rest.resource.Product;
import com.tcs.rest.services.ProductService;

@CrossOrigin(origins = "http://localhost:4200") //port number of angular application
@RestController
@RequestMapping("/product/v1")
public class ProductResource {

	@Autowired
	ProductService service;

	@GetMapping
	public String check() {
		return "/product/v1";
	}

	@GetMapping("/allproducts")
	public List<Product> showAllProducts() {
		return service.getProducts();
	}

	@GetMapping("/product/{id}")
	public Optional<Product> fetchProduct(@PathVariable int id) {
		return service.getProduct(id);
	}

	@PostMapping(path = "/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code= HttpStatus.CREATED)
	public String addProduct(@RequestBody Product product) {
		if (service.addProduct(product))
			return "Successfully added";
		return "failed to add";
	}

	@PutMapping(path = "/modifyproduct", 
				   consumes = MediaType.APPLICATION_JSON_VALUE,
				  produces = MediaType.APPLICATION_JSON_VALUE )
											
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		if(service.updateProduct(product))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated"); //"Successfully updated";
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed to update"); //"failed to update";
	}
	
	@DeleteMapping(path= "/deleteproduct",
			 consumes = MediaType.APPLICATION_JSON_VALUE,
			  produces = MediaType.APPLICATION_JSON_VALUE )
	public String deletProduct(@RequestBody Product obj)
	{
		if(service.deleteProduct(obj.getPid()))
			return "Successfully deleted";
		return "failed to delete";
	}

}
