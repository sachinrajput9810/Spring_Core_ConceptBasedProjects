package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class App {
   public static void main(String[] args) throws Exception {
	   ApplicationContext context = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml") ;
	   MainController controller = (MainController)context.getBean("contoller") ;
	   
	   Scanner scn = new Scanner(System.in) ;
	   System.out.println("Enter your name");
	   String name = scn.next();
	   System.out.println("Enter the principal amount");
	   String principalAmt = scn.next();
	   System.out.println("Enter the rate ");
	   String rate = scn.next();
	   System.out.println("Enter the time period");
	   String time = scn.next();
	   
	   CustomerVO vo = new CustomerVO() ;
	   vo.setName(name); vo.setPrincipalAmt(principalAmt); vo.setRate(rate); vo.setTime(time);
	   
	   try {
		   String result = controller.processCustomer(vo) ;
		   System.out.println(result);
	   } catch (Exception e) {
		   System.out.println("Internal issue : " + e.getMessage());
	   }
	   
   }
}  



