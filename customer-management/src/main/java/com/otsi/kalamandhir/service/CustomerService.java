/**
 * service for Customer
 */
package com.otsi.kalamandhir.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.otsi.kalamandhir.vo.CustomerVo;
import com.otsi.kalamandhir.vo.ListOfReturnSlipsVo;
import com.otsi.kalamandhir.vo.SearchFilterVo;

/**
 * @author vasavi
 */
@Service
public interface CustomerService {

	CustomerVo generateReturnSlip(CustomerVo vo);

	CustomerVo searchbyName(SearchFilterVo vo);

	CustomerVo saveCustomer(CustomerVo vo);

	List<ListOfReturnSlipsVo> getListOfReturnSlips(ListOfReturnSlipsVo vo);
}
