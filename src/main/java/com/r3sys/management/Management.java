package com.r3sys.management;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Management {
	@Id
	private String mpassword;
	private String memail;
	@Override
	public String toString() {
		return "Management [mpassword=" + mpassword + ", memail=" + memail + "]";
	}
	public Management() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Management(String mpassword, String memail) {
		super();
		this.mpassword = mpassword;
		this.memail = memail;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
}
