package com.henandoweb.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henandoweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
