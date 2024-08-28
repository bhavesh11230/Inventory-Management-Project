package com.r3sys.managementdao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.management.IssueProcess;

@Component
public class IssueProcessDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(IssueProcess issueprocess)
	{
		Integer i = (Integer)this.hibernateTemplate.save(issueprocess);
		return i;
	}
	
	public IssueProcess getIssueProcessMaterial(int ipid)
	{
		IssueProcess issueprocess = this.hibernateTemplate.get(IssueProcess.class, ipid);
		return issueprocess;
	}
	
	public List<IssueProcess> getAllIssueProcessMaterial()
	{
		List<IssueProcess> issueprocess = this.hibernateTemplate.loadAll(IssueProcess.class);
		return issueprocess;
	}
	
	@Transactional
	public void deleteIssueProcessMaterial(int ipid)
	{
		IssueProcess issueprocess = this.hibernateTemplate.get(IssueProcess.class, ipid);
		this.hibernateTemplate.delete(issueprocess);
	}
	
	@Transactional
	public void update(IssueProcess issueprocess)
	{
		this.hibernateTemplate.update(issueprocess);
	}

}
