package com.project.backend.controller;


import com.project.backend.dto.Message;
import com.project.backend.dto.OrderDto;
import com.project.backend.dto.ProductDto;
import com.project.backend.model.Order;
import com.project.backend.model.Product;
import com.project.backend.model.User;
import com.project.backend.security.service.UserService;
import com.project.backend.service.impl.OrdersServiceImpl;
import com.project.backend.service.impl.ProductServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrdersServiceImpl ordersService;

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderDto orderDto){
        if(orderDto.getUser()==null)
            return new ResponseEntity(new Message("You are not logged in"), HttpStatus.BAD_REQUEST);
        if(orderDto.getProducts()==null)
            return new ResponseEntity(new Message("There are no products"), HttpStatus.BAD_REQUEST);
        User user = userService.getByUsername(orderDto.getUser()).get();
        Order order = new Order(orderDto.getDate(), orderDto.getStatus(),orderDto.getProducts(),user);
        ordersService.save(order);
        return new ResponseEntity(new Message("Order created"), HttpStatus.OK);
    }


}
