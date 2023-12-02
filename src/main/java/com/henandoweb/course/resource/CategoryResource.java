package com.henandoweb.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henandoweb.course.entities.Category;
import com.henandoweb.course.servico.CategoryServico;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryServico servico;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint buscar por id:
	
     @GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long  id){
    	 Category obj = servico.findById(id);
    	 return ResponseEntity.ok().body(obj);		
	}
}
