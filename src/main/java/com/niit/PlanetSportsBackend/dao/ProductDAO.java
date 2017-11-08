package com.niit.PlanetSportsBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.Product;

@Repository("productDAO")
public class ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;
     
	public ProductDAO(SessionFactory sessionFactory)
	{
       this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
   
	public Product getProduct(int prodid)
    {

    	Session session= sessionFactory.openSession();
    	Product product=(Product)session.get(Product.class,prodid);
    	session.close();
    	return product;
    }
    
    
    @Transactional
	public void deleteProduct(Product product)
	{
		sessionFactory.getCurrentSession().delete(product);
		
	}
	
    
    
    
	public List<Product> getProductDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> list=query.list();
		session.close();
		return list;
	}
  
	public List<Product> getProductByCategory(int catid)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product WHERE catid = :catid" , Product.class)
				.setParameter("catid", catid);
		List<Product> list=query.list();
		session.close();
		return list;
	}
	
	/*public List<Product> getProductByCategory(int catid)
	{
        String selectProductsByCategory = "from Product WHERE catid = :catid"; 
        return sessionFactory.openSession()
        		.createQuery(selectProductsByCategory, Product.class)
        		.setParameter("catid", catid)
        		.list();
    }*/
	
	public List<Product> getLatestProduct(int count)
    {
    	Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product ORDER By prodid",Product.class)
				.setFirstResult(0).setMaxResults(count);
		List<Product> list=query.list();
		session.close();
		return list;
    }
	
}
