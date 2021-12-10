package com.project.backend.dto;

public class UserInfoDto {


    private Integer phone;
    private String addressLine;
    private String city;
    private String state;
    private Integer postalCode;
    private String country;

    public UserInfoDto() {
    }

    public UserInfoDto(Integer phone, String addressLine, String city, String state, Integer postal_code, String country) {
        this.phone = phone;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.postalCode = postal_code;
        this.country = country;
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

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
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

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
