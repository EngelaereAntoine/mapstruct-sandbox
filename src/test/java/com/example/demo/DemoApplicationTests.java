package com.example.demo;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.BillingAddressDto;
import com.example.demo.dto.CompanyDto;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.model.Address;
import com.example.demo.model.Company;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoApplicationTests {

	private static final CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);


	private static Address address() {
		Address address = new Address();
		address.setCity("city");
		return address;
	}

	private static AddressDto addressDto() {
		AddressDto dto = new AddressDto();
		dto.setCity("city");
		return dto;
	}

	private static Company company() {
		Company entity = new Company();
		entity.setName("name");
		entity.setAddress(address());
		entity.getAddress().setCompany(entity);
		entity.setBillingAddress(address());
		entity.getBillingAddress().setDevise("euros");
		entity.getBillingAddress().setCompany(entity);
		return entity;
	}

	private static CompanyDto companyDto() {
		CompanyDto dto= new CompanyDto();
		dto.setName("name");
		dto.setAddress(addressDto());
		dto.setBillingAddress(new BillingAddressDto());
		dto.getBillingAddress().setAddressDto(addressDto());
		dto.getBillingAddress().setDevise("euros");
		return dto;
	}

	@Test
	public void toDto() {
		assertThat(MAPPER.toDto(company())).isEqualToComparingFieldByFieldRecursively(companyDto());
	}

	@Test
	public void toEntity() {
		assertThat(MAPPER.toEntity(companyDto())).isEqualToComparingFieldByFieldRecursively(company());
	}

}
