package com.example.demo.dto;

import lombok.Data;

public class AddressDto {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
