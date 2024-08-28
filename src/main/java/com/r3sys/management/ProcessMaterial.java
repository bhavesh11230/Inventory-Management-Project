package com.r3sys.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ProcessMaterial {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int pid;
	private String pname;
	private int pquantity;
	private String punit;
	private float pcost;
	
	@Override
	public String toString() {
		return "ProcessMaterial [pid=" + pid + ", pname=" + pname + ", pquantity=" + pquantity + ", punit=" + punit
				+ ", pcost=" + pcost + "]";
	}
	public ProcessMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcessMaterial(int pid, String pname, int pquantity, String punit, float pcost) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pquantity = pquantity;
		this.punit = punit;
		this.pcost = pcost;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public String getPunit() {
		return punit;
	}
	public void setPunit(String punit) {
		this.punit = punit;
	}
	public float getPcost() {
		return pcost;
	}
	public void setPcost(float pcost) {
		this.pcost = pcost;
	}

}
