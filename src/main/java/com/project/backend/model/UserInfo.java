package com.project.backend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer phone;
    private String addressLine;
    private String city;
    private String state;
    private Integer postalCode;
    private String country;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;


    public UserInfo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String address_line) {
        this.addressLine = address_line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postal_code) {
        this.postalCode = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
