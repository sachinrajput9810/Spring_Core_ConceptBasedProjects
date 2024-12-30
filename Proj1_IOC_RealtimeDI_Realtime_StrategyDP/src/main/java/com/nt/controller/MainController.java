package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

public class MainController {
	
	private IEmployeeMgmtService service ;

	public MainController(IEmployeeMgmtService service) {
		System.out.println("Inside Main Controller 1 param constructor ");
		this.service = service;
	}
	
	public String processEmployee(EmployeeVO vo) throws Exception {
		
		EmployeeDTO dto = new EmployeeDTO() ;
		dto.setEname(vo.getEname());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		// use service
		String result = service.registerEmployee(dto) ;
		return result ;
		
	}
	
	
	
	
}
