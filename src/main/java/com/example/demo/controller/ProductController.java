package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ProductRepository;

@RestController
@CrossOrigin(origins="http//localhost:8804")

public class ProductController {
	Optional<products> p1;
	
	@Autowired
	private ProductRepository prepository;
	
	@GetMapping("/products")
	public List<products> getAllProducts(){
		return prepository.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity getProductsById(@PathVariable(value="id") Long prod_id) {
		p1 = prepository.findById(prod_id);
		return ResponseEntity.ok().body(p1);
	}
	
	@PostMapping(value="/products")
	public products saveEmployees(@RequestBody products prod) {
		return prepository.save(prod);
	}
	
	@PutMapping(value="/products/{id}")
	public ResponseEntity updateProducts (@PathVariable(value="id") Long prod_id,
	@Valid @RequestBody products pdata){
		p1 = prepository.findById(prod_id);
		products e2 = p1.get();
		e2.setProd_id(pdata.getProd_id());
		e2.setProd_name(pdata.getProd_name());
		e2.setProd_category(pdata.getProd_category());
		e2.setProd_price(pdata.getProd_price());
		e2.setProd_color(pdata.getProd_color());
		
		products updateProducts = prepository.save(e2);
		return ResponseEntity.ok(updateProducts);
	}
	
	@DeleteMapping(value="/products/{id}")
	public ResponseEntity deleteEmployee(@PathVariable(value="id")Long prod_id) {
		prepository.deleteById(prod_id);
		return ResponseEntity.noContent().build();
	}
	
	
}

