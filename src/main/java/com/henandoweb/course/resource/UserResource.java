package com.henandoweb.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henandoweb.course.entities.User;
import com.henandoweb.course.servico.UserServico;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserServico servico;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
     @GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long  id){
    	 User obj = servico.findById(id);
    	 return ResponseEntity.ok().body(obj);		
	}
}
