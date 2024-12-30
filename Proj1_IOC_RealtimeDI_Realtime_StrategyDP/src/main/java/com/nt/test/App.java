package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

/**
 * Hello world!
 */
public class App {
   public static void main(String[] args) throws Exception {
	   ApplicationContext context = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml") ;
	   MainController controller = (MainController)context.getBean("controller") ;
	   // reading VO class object
	   Scanner scn = new Scanner(System.in) ;
	   System.out.println("Enter your name ") ;
	   String name = scn.next();
	   
	   System.out.println("Enter your Designation ") ;
	   String desg = scn.next();
	   
	   System.out.println("Enter your basic salary ") ;
	   String basicSalary = scn.next();
	   
	   EmployeeVO vo = new EmployeeVO() ;
	   vo.setEname(name) ; vo.setDesg(desg) ; vo.setBasicSalary(basicSalary) ;
	   
	   try{
		   String result = controller.processEmployee(vo) ;
		   System.out.println(result);
	   } catch (Exception e) {
		   System.out.println("Internal Error : " + e.getMessage());
	   }
		   
   }
}  



