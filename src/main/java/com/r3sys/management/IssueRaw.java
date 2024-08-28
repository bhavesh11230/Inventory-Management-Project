package com.r3sys.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueRaw {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int irid;
	private int rid;
	private String rname;
	private String irname;
	private int irquantity;
	private String irdate;
	private String irtime;
	public int getIrid() {
		return irid;
	}
	public void setIrid(int irid) {
		this.irid = irid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getIrname() {
		return irname;
	}
	public void setIrname(String irname) {
		this.irname = irname;
	}
	public int getIrquantity() {
		return irquantity;
	}
	public void setIrquantity(int irquantity) {
		this.irquantity = irquantity;
	}
	public String getIrdate() {
		return irdate;
	}
	public void setIrdate(String irdate) {
		this.irdate = irdate;
	}
	public String getIrtime() {
		return irtime;
	}
	public void setIrtime(String irtime) {
		this.irtime = irtime;
	}
	public IssueRaw(int irid, int rid, String rname, String irname, int irquantity, String irdate, String irtime) {
		super();
		this.irid = irid;
		this.rid = rid;
		this.rname = rname;
		this.irname = irname;
		this.irquantity = irquantity;
		this.irdate = irdate;
		this.irtime = irtime;
	}
	public IssueRaw() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IssueRaw [irid=" + irid + ", rid=" + rid + ", rname=" + rname + ", irname=" + irname + ", irquantity="
				+ irquantity + ", irdate=" + irdate + ", irtime=" + irtime + "]";
	}
	
	
}
