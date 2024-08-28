package com.r3sys.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class IssueProcess {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int ipid;
	private int pid;
	private String pname;
	private String ipname;
	private int ipquantity;
	@Override
	public String toString() {
		return "IssueProcess [ipid=" + ipid + ", pid=" + pid + ", pname=" + pname + ", ipname=" + ipname
				+ ", ipquantity=" + ipquantity + ", ipdate=" + ipdate + ", iptime=" + iptime + "]";
	}
	public IssueProcess() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IssueProcess(int ipid, int pid, String pname, String ipname, int ipquantity, String ipdate, String iptime) {
		super();
		this.ipid = ipid;
		this.pid = pid;
		this.pname = pname;
		this.ipname = ipname;
		this.ipquantity = ipquantity;
		this.ipdate = ipdate;
		this.iptime = iptime;
	}
	public int getIpid() {
		return ipid;
	}
	public void setIpid(int ipid) {
		this.ipid = ipid;
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
	public String getIpname() {
		return ipname;
	}
	public void setIpname(String ipname) {
		this.ipname = ipname;
	}
	public int getIpquantity() {
		return ipquantity;
	}
	public void setIpquantity(int ipquantity) {
		this.ipquantity = ipquantity;
	}
	public String getIpdate() {
		return ipdate;
	}
	public void setIpdate(String ipdate) {
		this.ipdate = ipdate;
	}
	public String getIptime() {
		return iptime;
	}
	public void setIptime(String iptime) {
		this.iptime = iptime;
	}
	private String ipdate;
	private String iptime;
}
