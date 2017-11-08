package com.niit.PlanetSportsBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int catid;
	
	@NotBlank(message= "Please enter the Category Name!")
	String catname;
	@JsonIgnore
	@NotBlank(message= "Please enter the Category Description!")
	String catdesc;

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdesc() {
		return catdesc;
	}

	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}
	

}
