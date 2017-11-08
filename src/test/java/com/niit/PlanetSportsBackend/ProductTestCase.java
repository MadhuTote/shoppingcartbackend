package com.niit.PlanetSportsBackend;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.model.Product;

public class ProductTestCase
{
	public static void main(String args[])
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.PlanetSportsBackend");
		context.refresh();
		
		
		//Inserting a Product object
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		//Inserting Test Case
		Product product=new Product();
		product.setProdname("Spalding NBA Rebound BasketBall..");
		product.setCatid(2);
		product.setSuppid(0);
		product.setQuantity(5);
		product.setPrice(800);
		product.setProddesc("This product comes with a highly durable rubber covering..");
		
		productDAO.insertUpdateProduct(product);
		System.out.println("Product Inserted");
		
		
		//Retrieval TestCase
		    /*
				Product product=productDAO.getProduct(2);
				System.out.println("Product Name:"+product.getProdname());
				System.out.println("Product Description:"+product.getProddesc());
		
		    */
		//Deletion TestCase
				/*
		        Product product=productDAO.getProduct(2);
				productDAO.deleteProduct(product);
				System.out.println("The Product Deleted");
		
		      */
		//Retrieving the Data
		    /*  
			  List<Product> list=productDAO.getProductDetails();
				
				for(Product product:list)
				{
					System.out.println(product.getProdid()+":"+product.getProdname()+":"+product.getProddesc()+":"+product.getCatid()+":"+product.getPrice()+":"+product.getSuppid()+":"+product.getQuantity());
				}
		  
		      */
	/*	List<Product> list=productDAO.getProductByCategory(2);
		
		for(Product product:list)
		{
			System.out.println(product.getProdid()+":"+product.getProdname()+":"+product.getProddesc()+":"+product.getCatid()+":"+product.getPrice()+":"+product.getSuppid()+":"+product.getQuantity());
		}
  */
		
		//Update the Category
			/*	
		        Product product=productDAO.getProduct(3);
				product.setProdname(" Football Shoes  ");
				product.setCatid(2);
				product.setSuppid(200);
				product.setQuantity(2);
				product.setPrice(2500);
				product.setProddesc("This is famous shoes");
				productDAO.insertUpdateProduct(product);
				System.out.println("The Product Updated");
		    */		
		
	}

}
