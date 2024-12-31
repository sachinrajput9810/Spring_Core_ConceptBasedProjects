package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	private IEmployeeDAO dao ; 
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		System.out.println("Employee Management Service 1 param constructor");
		this.dao = dao;
	}

	
	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		// business logic for net and gross salary
		System.out.println("Register Employee method called " ) ;
		float grossSalary = dto.getBasicSalary() + dto.getBasicSalary()*0.4f ;
		float netSalary = grossSalary - dto.getBasicSalary()*0.2f ;
		
		EmployeeBO bo = new EmployeeBO() ;
		bo.setEname(dto.getEname());
		bo.setDesg(dto.getDesg());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary); 
		
		int count = dao.insertEmployee(bo) ;
		return count==1 ? "Employee registered with net salary " + netSalary : "Employee not registred with netsalary " + netSalary ;
		
	}


}
 