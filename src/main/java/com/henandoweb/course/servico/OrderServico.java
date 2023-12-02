package com.henandoweb.course.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henandoweb.course.entities.Order;
import com.henandoweb.course.repository.OrderRepository;

@Service
public class OrderServico {
	
     @Autowired
	private OrderRepository repository;
     
     public List<Order> findAll(){
    	return repository.findAll();
    	 
     }
     
 	// buscar porOrderServico.java id:
     public Order findById(Long id){
    	 Optional<Order> obj = repository.findById(id);
    	 return obj.get();
     }
	
}
