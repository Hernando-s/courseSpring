package com.henandoweb.course.servico.exeption;

public class ResourceNotFoundExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExeption(Object id) {
		super("Resource not found. id " + id);
	}

}
