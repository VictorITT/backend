package com.project.backend.repository;

import com.project.backend.model.Order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Order,Integer> {

}
