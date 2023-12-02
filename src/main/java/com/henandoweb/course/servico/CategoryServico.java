package com.henandoweb.course.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henandoweb.course.entities.Category;
import com.henandoweb.course.repository.CategoryRepository;

@Service
public class CategoryServico {
	
     @Autowired
	private CategoryRepository repository;
     
	public List<Category> findAll(){
    	return repository.findAll();
    	 
     }
     
 	// buscar porCategoryServico.java id:
     public Category findById(Long id){
    	 Optional<Category> obj = repository.findById(id);
    	 return obj.get();
     }
	
}
