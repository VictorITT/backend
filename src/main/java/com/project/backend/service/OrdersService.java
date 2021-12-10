package com.project.backend.service;

import com.project.backend.model.Order;

import java.util.List;

public interface OrdersService {
    void  save(Order order);
    void delete(int id);
}
