package com.niit.PlanetSportsBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.PlanetSportsBackend.dao.SupplierDAO;

import com.niit.PlanetSportsBackend.model.Supplier;



public class SupplierTestCase
{
	public static void main(String args[])
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.PlanetSportsBackend");
		context.refresh();
	
		//Inserting a Category object
	    SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	    
	  //Inserting Test Case
	  		Supplier supplier=new Supplier();
	  		supplier.setSuppname("Blue Dart");
	  		supplier.setAddress("Mumbai...");
	  		
	  		supplierDAO.insertUpdateSupplier(supplier);
	  		System.out.println("Supplier Inserted");
	  		
	  		//Retrieval TestCase
	  		
	  			/*	Supplier supplier=supplierDAO.getSupplier(3);
	  				System.out.println("Supplier Name:"+supplier.getSuppname());
	  				System.out.println("Supplier Address:"+supplier.getAddress());
	             */
	  		
	  		//Deletion TestCase
	  		    /*
	  		       Supplier supplier=supplierDAO.getSupplier(3);
	  				supplierDAO.deleteSupplier(supplier);
	  				System.out.println("The Supplier Deleted");
	  		    */
	  		//Retrieving the Data
	  		     /*
	  			  List<Supplier> list=supplierDAO.getSupplierDetails();
	  				
	  				for(Supplier supplier:list)
	  				{
	  					System.out.println(supplier.getSuppid()+":"+supplier.getSuppname()+":"+supplier.getAddress());
	  				}
	  		      */
	  		//Update the Category
	  				/*
	  		       Supplier supplier=supplierDAO.getSupplier(3);
	  				supplier.setSuppname("E-KART Logistics ");
	  				supplierDAO.insertUpdateCategory(supplier);
	  				System.out.println("The Supplier Updated");
	  				*/

	}	
}
