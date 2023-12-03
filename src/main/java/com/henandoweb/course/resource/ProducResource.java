package com.henandoweb.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henandoweb.course.entities.Product;
import com.henandoweb.course.servico.ProductServico;

@RestController
@RequestMapping(value = "/products")
public class ProducResource {
	
	@Autowired
	private ProductServico servico;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint buscar por id:
	
     @GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long  id){
    	 Product obj = servico.findById(id);
    	 return ResponseEntity.ok().body(obj);		
	}
}
