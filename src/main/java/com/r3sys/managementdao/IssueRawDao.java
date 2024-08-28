package com.r3sys.managementdao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.management.IssueRaw;

@Component
public class IssueRawDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(IssueRaw issueraw)
	{
		Integer i = (Integer)this.hibernateTemplate.save(issueraw);
		return i;
	}
	
	public IssueRaw getIssueRawMaterial(int irid)
	{
		IssueRaw issueraw = this.hibernateTemplate.get(IssueRaw.class, irid);
		return issueraw;
	}
	
	public List<IssueRaw> getAllIssueProcessMaterial()
	{
		List<IssueRaw> issueraw = this.hibernateTemplate.loadAll(IssueRaw.class);
		return issueraw;
	}
	
	@Transactional
	public void deleteIssueRawMaterial(int irid)
	{
		IssueRaw issueraw = this.hibernateTemplate.get(IssueRaw.class, irid);
		this.hibernateTemplate.delete(issueraw);
	}
	
	@Transactional
	public void update(IssueRaw issueraw)
	{
		this.hibernateTemplate.update(issueraw);
	}
}
