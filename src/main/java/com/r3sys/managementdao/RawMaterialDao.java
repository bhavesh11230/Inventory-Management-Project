package com.r3sys.managementdao;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.r3sys.management.RawMaterial;;

@Component
public class RawMaterialDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(RawMaterial rawmaterial)
	{
		Integer i = (Integer)this.hibernateTemplate.save(rawmaterial);
		return i;
	}
	
	public RawMaterial getRawMaterial(int rid)
	{
		RawMaterial rawmaterial = this.hibernateTemplate.get(RawMaterial.class, rid);
		return rawmaterial;
	}
	
	public List<RawMaterial> getAllRawMaterial()
	{
		List<RawMaterial> rawmaterial = this.hibernateTemplate.loadAll(RawMaterial.class);
		return rawmaterial;
	}
	
	@Transactional
	public void deleteRawMaterial(int rid)
	{
		RawMaterial rawmaterial = this.hibernateTemplate.get(RawMaterial.class, rid);
		this.hibernateTemplate.delete(rawmaterial);
	}
	
	@Transactional
	public void update(RawMaterial rawmaterial)
	{
		this.hibernateTemplate.update(rawmaterial);
	}

}
