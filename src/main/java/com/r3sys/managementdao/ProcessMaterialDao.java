package com.r3sys.managementdao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.management.ProcessMaterial;

@Component
public class ProcessMaterialDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(ProcessMaterial processmaterial)
	{
		Integer i = (Integer)this.hibernateTemplate.save(processmaterial);
		return i;
	}
	
	public ProcessMaterial getProcessMaterial(int rid)
	{
		ProcessMaterial processmaterial = this.hibernateTemplate.get(ProcessMaterial.class, rid);
		return processmaterial;
	}
	
	public List<ProcessMaterial> getAllProcessMaterial()
	{
		List<ProcessMaterial> processmaterial = this.hibernateTemplate.loadAll(ProcessMaterial.class);
		return processmaterial;
	}
	
	@Transactional
	public void deleteProcessMaterial(int rid)
	{
		ProcessMaterial processmaterial = this.hibernateTemplate.get(ProcessMaterial.class, rid);
		this.hibernateTemplate.delete(processmaterial);
	}
	
	@Transactional
	public void update(ProcessMaterial processmaterial)
	{
		this.hibernateTemplate.update(processmaterial);
	}
}
