package com.niit.PlanetSportsBackend.dao;

import java.util.List;



import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.PlanetSportsBackend.model.Cart;
import com.niit.PlanetSportsBackend.model.UserDetail;

@Repository("userdetailDAO")
public class UserDetailDAO 
{
	@Autowired
	SessionFactory sessionFactory;
     
	public UserDetailDAO(SessionFactory sessionFactory)
	{
       this.sessionFactory=sessionFactory;
	}
	
    @Transactional
	public void insertUpdateUserDetail(UserDetail userdetail)
	{
    	
		Session session=sessionFactory.getCurrentSession();
		userdetail.setEnabled(true);
		userdetail.setRole("USER");
		Cart cart=new Cart();
		cart.setUserdetail(userdetail);
		userdetail.setCart(cart);
		session.saveOrUpdate(userdetail);
	}
   
    @Transactional
    public UserDetail getUserDetail(String username)
    {

    	Session session= sessionFactory.openSession();
    	UserDetail userdetail=(UserDetail)session.get(UserDetail.class,username);
    	session.close();
    	return userdetail;
    }
    
    @Transactional
    public UserDetail getByUsername(String username)
    {
    	String selectQuery = "FROM UserDetail WHERE username = :username";
    	 try{
    		return sessionFactory.getCurrentSession()
    				.createQuery(selectQuery,UserDetail.class)
    				.setParameter("username", username)
    				.getSingleResult();
    	 }
    	catch(Exception ex)
    	 {
    		return null;
    	 }
    }
    
	
	@Transactional
	@SuppressWarnings("deprecation")
	public UserDetail validateUsername(String username)
    {
		 Session session=sessionFactory.getCurrentSession();
		 @SuppressWarnings("rawtypes")
		Query query=session.createQuery("from UserDetail where username=?");
		  query.setString(0,username);
		 UserDetail userdetail=(UserDetail) query.uniqueResult();   
         return userdetail;	
    }   
	
   
	@Transactional
	 @SuppressWarnings("deprecation")
	public UserDetail validateEmail(String email)
    {
		 Session session=sessionFactory.getCurrentSession();
		 @SuppressWarnings("rawtypes")
		Query query=session.createQuery("from UserDetail where email=?");
		 query.setString(0, email);
		 UserDetail userdetail=(UserDetail) query.uniqueResult();   
         return userdetail;	
    }
    
    
	@Transactional
	@SuppressWarnings("deprecation")
	public UserDetail validateCustomername(String custname)
    {
		 Session session=sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from UserDetail where custname=?");
		 query.setString(0,custname);
		 UserDetail userdetail=(UserDetail) query.uniqueResult();   
         return userdetail;	
    }
              
      
    
	public List<UserDetail> getUserDetailDetails()
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> list=query.list();
		session.close();
		return list;
	}
}
