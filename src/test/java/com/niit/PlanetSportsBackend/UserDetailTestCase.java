package com.niit.PlanetSportsBackend;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.model.Cart;
import com.niit.PlanetSportsBackend.model.UserDetail;


public class UserDetailTestCase 
{
	public static void main(String args[])
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.PlanetSportsBackend");
		context.refresh();
		
		
		//Inserting a UserDetail object
		UserDetailDAO userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
		
		//Inserting Test Case
	 /*	UserDetail userdetail=new UserDetail();
		 userdetail.setUsername("Shreyas Purohit");
		 userdetail.setAddress("1121/E,Vasant Villa, Sykes Extension, Kolhapur");
	    userdetail.setCustname("sniper_1994");
	    userdetail.setEmail("purohitshreyas94@gmail.com");
	    userdetail.setEnabled(true);
	    userdetail.setMobile("7507854284");
	    userdetail.setPassword("shreyas@123");
	    userdetail.setRole("ADMIN");
	   
		userdetailDAO.insertUpdateUserDetail(userdetail);
		System.out.println("User Details Inserted..");
	*/	
		UserDetail userdetail=new UserDetail();
		Cart cart=new Cart();
		 userdetail.setUsername("Shreyas");
		 userdetail.setAddress("Kolhapur");
	    userdetail.setCustname("shreyas@94");
	    userdetail.setEmail("shreyas@gmail.com");
	    userdetail.setEnabled(true);
	    userdetail.setMobile("8446530101");
	    userdetail.setPassword("1234");
	    userdetail.setRole("USER");
	   
	    	cart=new Cart();
	    	cart.setUserdetail(userdetail);
	    	userdetail.setCart(cart);
	    	
	    
	    
	    
		userdetailDAO.insertUpdateUserDetail(userdetail);
		System.out.println("User Details Inserted..");
		
	
		//Retrieval TestCase
		 /*
		UserDetail userdetail=userdetailDAO.getUserDetail("shreyas");
				System.out.println("User Address:"+userdetail.getAddress());
				System.out.println("Customer Name:"+userdetail.getCustname());
				System.out.println("User Email:"+userdetail.getEmail());
				System.out.println("User Mobile Number:"+userdetail.getMobile());
				System.out.println("User Password :"+userdetail.getPassword());
				System.out.println("User Role:"+userdetail.getRole());
	        
	        	
				
		//Retrieving the Data
		
			  List<UserDetail> list=userdetailDAO.getUserDetailDetails();
				
				for(UserDetail userdetail:list)
				{
					System.out.println(userdetail.getUsername()+":"+userdetail.getAddress()+":"+userdetail.getCustname()+":"+userdetail.getEmail()+":"+userdetail.getMobile()+":"+userdetail.getPassword()+":"+userdetail.getRole());
				}
		      
		//Update the Category
				UserDetail userdetail=userdetailDAO.getUserDetail("shreyas");
				category.setCatname("Dell with 1TB HardDisc ");
				categoryDAO.insertUpdateCategory(category);
				System.out.println("The Category Updated");*/
				
		
	}

}
