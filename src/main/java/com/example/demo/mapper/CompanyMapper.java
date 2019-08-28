package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BillingAddressDto;
import com.example.demo.dto.CompanyDto;
import com.example.demo.model.Address;
import com.example.demo.model.Company;
import org.mapstruct.*;

import java.util.Optional;

@Mapper
public interface CompanyMapper {

    @Mapping(target = "billingAddress", qualifiedByName = "toAddress")
    Company toEntity(CompanyDto dto);

    @AfterMapping
    default void jpa(@MappingTarget Company company) {
        company.getAddress().setCompany(company);
        company.getBillingAddress().setCompany(company);
    }

    @Mapping(target = "billingAddress", qualifiedByName = "billingAddressDto")
    CompanyDto toDto(Company entity);

    AddressDto addressToAddressDto(Address address);

    Address addressDtoToAddress(AddressDto dto);

    BillingAddressDto addressToBillingAddressDto(Address address);

    Address billingAddressDtoToAddress(BillingAddressDto dto, @MappingTarget Address address);

    @Named("billingAddressDto")
    default BillingAddressDto billingAddressDto(Address address) {
        return Optional.ofNullable(address)
                .map(this::addressToAddressDto)
                .map(addressDto -> addressToBillingAddressDto(address).addressDto(addressDto))
                .orElse(null);
    }

    @Named("toAddress")
    default Address toAddress(BillingAddressDto dto) {
        return Optional.ofNullable(dto)
                .map(BillingAddressDto::getAddressDto)
                .map(this::addressDtoToAddress)
                .map(address -> billingAddressDtoToAddress(dto, address))
                .orElse(null);
    }

}
