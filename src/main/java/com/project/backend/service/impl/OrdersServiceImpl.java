package com.project.backend.service.impl;

import com.project.backend.model.Order;
import com.project.backend.repository.OrdersRepository;
import com.project.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    OrdersRepository ordersRepository;


    public void  save(Order order){
        ordersRepository.save(order);
    }

    public void delete(int id){
        ordersRepository.deleteById(id);
    }

}
