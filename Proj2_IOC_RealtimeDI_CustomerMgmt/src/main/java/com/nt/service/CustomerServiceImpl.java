package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomberDAO;
import com.nt.dto.CustomerDTO;

public class CustomerServiceImpl implements ICustomerService {
	
	private ICustomberDAO dao ;
	
	public CustomerServiceImpl(ICustomberDAO dao) {
		System.out.println("CustomerServiceImpl:: 1 param constructor");
		this.dao = dao;
	}


	@Override
	public String registerCustomer(CustomerDTO dto) throws Exception {
		System.out.println("Register method in service called");
		// business logic
		int Intrest = (dto.getPrincipalAmt()*dto.getRate()*dto.getTime())/100 ;
		int payAmt = dto.getPrincipalAmt() + Intrest ;
		
		CustomerBO bo = new CustomerBO() ;
		bo.setName(dto.getName());
		bo.setPrincipalAmt(dto.getPrincipalAmt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setPayAmt(payAmt);
		
		int count = dao.insertCustomer(bo) ;
		if(count == 1) {
			return "Customer inserted sucessfully with pay amount " + payAmt ; 
		}
		else return "Customer insertion failed with pay amount " + payAmt ; 
	
	}

	
}
