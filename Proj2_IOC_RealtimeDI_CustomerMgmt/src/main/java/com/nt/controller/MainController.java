package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerService;
import com.nt.vo.CustomerVO;

public class MainController {
	
	private ICustomerService service ;

	public MainController(ICustomerService service) {
		System.out.println("MainController:: 1 param constructor");
		this.service = service;
	}
	
	public String processCustomer(CustomerVO vo) throws Exception {
		System.out.println("process customer called in Main controller");
		CustomerDTO dto = new CustomerDTO() ;
		dto.setName(vo.getName());
		dto.setPrincipalAmt(Integer.parseInt(vo.getPrincipalAmt()));
		dto.setRate(Integer.parseInt(vo.getRate()));
		dto.setTime(Integer.parseInt(vo.getTime()));
		String result = service.registerCustomer(dto) ;
		return result ;
 	}
	
}
