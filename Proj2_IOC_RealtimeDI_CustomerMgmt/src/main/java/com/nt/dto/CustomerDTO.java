package com.nt.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	
	private String name ;
	private Integer principalAmt ;
	private Integer rate ;
	private Integer time ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrincipalAmt() {
		return principalAmt;
	}
	public void setPrincipalAmt(Integer principalAmt) {
		this.principalAmt = principalAmt;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	
}
