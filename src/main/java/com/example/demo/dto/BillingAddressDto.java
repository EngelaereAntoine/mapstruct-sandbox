package com.example.demo.dto;

public class BillingAddressDto {
    private String devise;
    private AddressDto addressDto;

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public String getDevise() {
        return devise;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public BillingAddressDto addressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }
}
