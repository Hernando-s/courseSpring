package com.henandoweb.course.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henandoweb.course.entities.Product;
import com.henandoweb.course.repository.ProductRepository;

@Service
public class ProductServico {
	
     @Autowired
	private ProductRepository repository;
     
     public List<Product> findAll(){
    	return repository.findAll();
    	 
     }
     
 	// buscar porProductServico.java id:
     public Product findById(Long id){
    	 Optional<Product> obj = repository.findById(id);
    	 return obj.get();
     }
	
}
