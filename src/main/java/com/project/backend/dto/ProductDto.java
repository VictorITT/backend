package com.project.backend.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductDto {

    @NotBlank
    private String name;
    @NotBlank
    private String image;
    @Min(0)
    private Float price;

    public ProductDto() {
    }

    public ProductDto(@NotBlank String name, @Min(0) Float price) {
        this.name = name;
        this.price = price;
    }

    public ProductDto(String name, String image, Float price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
