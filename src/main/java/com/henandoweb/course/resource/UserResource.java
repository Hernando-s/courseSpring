package com.henandoweb.course.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.henandoweb.course.entities.User;
import com.henandoweb.course.servico.UserServico;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserServico servico;
	
	
     //endpoint busca usuarios
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//endpoint busca usuario por id:
	
     @GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long  id){
    	 User obj = servico.findById(id);
    	 return ResponseEntity.ok().body(obj);		
	}
     
     //endpoint inseri um usuario no banco
     @PostMapping
     public ResponseEntity<User> inser(@RequestBody User obj){
    	 obj = servico.insert(obj);
    	 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
    			 .buildAndExpand(obj.getId()).toUri();
    	 return ResponseEntity.created(uri).body(obj);
     }
     //endpoint deleta um usuario no banco
     
     @DeleteMapping(value ="/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id){
    	 servico.delete(id);
    	 return ResponseEntity.noContent().build();
     }
     
   //endpoint atualiza dados do usuario no banco
     @PutMapping(value = "/{id}")
     public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
    	 obj = servico.update(id, obj);
    	 return ResponseEntity.ok().body(obj);
    	 
     }
    
}
