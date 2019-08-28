package com.example.demo.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private String name;
    private AddressDto address;
    private BillingAddressDto billingAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public BillingAddressDto getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressDto billingAddress) {
        this.billingAddress = billingAddress;
    }
}
