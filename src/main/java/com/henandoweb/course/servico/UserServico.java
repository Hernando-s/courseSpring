package com.henandoweb.course.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.henandoweb.course.entities.User;
import com.henandoweb.course.repository.UserRepository;
import com.henandoweb.course.servico.exeption.DatabaseException;
import com.henandoweb.course.servico.exeption.ResourceNotFoundExeption;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServico {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();

	}

	// buscar por id:
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundExeption(id));
	}

	// inseri um usuario no banco
	public User insert(User obj) {
		return repository.save(obj);
	}

	// deleta um usuario do banco
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeption(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	// atualiza dados do usuario
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundExeption(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
