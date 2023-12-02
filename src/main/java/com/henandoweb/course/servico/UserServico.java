package com.henandoweb.course.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henandoweb.course.entities.User;
import com.henandoweb.course.repository.UserRepository;

@Service
public class UserServico {
	
     @Autowired
	private UserRepository repository;
     
     public List<User> findAll(){
    	return repository.findAll();
    	 
     }
     
 	// buscar porUserServico.java id:
     public User findById(Long id){
    	 Optional<User> obj = repository.findById(id);
    	 return obj.get();
     }
	
}
