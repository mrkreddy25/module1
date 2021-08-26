/**
 * mapper for Customer
 */
package com.otsi.kalamandhir.mapper;

import org.springframework.stereotype.Component;
import com.otsi.kalamandhir.model.Customer;
import com.otsi.kalamandhir.vo.CustomerVo;

/**
 * @author vasavi
 *
 */
@Component
public class CustomerMapper {

	/*
	 * EntityToVo converts dto to vo
	 * 
	 */

	public CustomerVo EntityToVo(Customer dto) {
		CustomerVo vo = new CustomerVo();
		vo.setId(dto.getId());
		vo.setCustomerName(dto.getCustomerName());
		vo.setCustomerEmail(dto.getCustomerEmail());
		vo.setDateOfBirth(dto.getDateOfBirth());
		vo.setGender(dto.getGender());
		vo.setAddress(dto.getAddress());
		vo.setMobileNumber(dto.getMobileNumber());
		vo.setCustomerGstNo(dto.getCustomerGstNo());

		return vo;
	}

	/*
	 * mapVoToEntity converts vo to dto
	 * 
	 */

	public Customer mapVoToEntity(CustomerVo vo) {

		Customer dto = new Customer();
		dto.setId(vo.getId());
		dto.setCustomerName(vo.getCustomerName());
		dto.setCustomerEmail(vo.getCustomerEmail());
		dto.setDateOfBirth(vo.getDateOfBirth());
		dto.setGender(vo.getGender());
		dto.setAddress(vo.getAddress());
		dto.setMobileNumber(vo.getMobileNumber());
		dto.setCustomerGstNo(vo.getCustomerGstNo());
        return dto;

	}

}
