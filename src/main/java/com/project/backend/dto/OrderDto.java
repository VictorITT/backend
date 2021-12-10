package com.project.backend.dto;

import com.project.backend.model.Product;
import com.project.backend.model.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderDto {


    private Date date;
    private String status;
    private List<Product> products;
    private String user;

    public OrderDto() {
    }

    public OrderDto(Date date, String status,List<Product> products, String user) {
        this.date = date;
        this.status = status;
        this.products = products;
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "date=" + date +
                ", status='" + status + '\'' +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
