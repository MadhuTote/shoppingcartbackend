
package com.niit.PlanetSportsBackend.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.PlanetSportsBackend.model.Cart;

@Repository("cartDAO")
public class CartDAO 
{
 
		@Autowired
		SessionFactory sessionFactory;
		
		public CartDAO(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public void addToCart(Cart cartitem)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cartitem);
			
		}
		public List<Cart> getCartItems(String username)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:username");
			query.setParameter("username", username);
			@SuppressWarnings("Unchacked")
			List<Cart> list=query.list();
			return list;
			
		}
		public List<Cart> getCartDetails(String username)
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:username");
			query.setParameter("username", username);
			List<Cart> list=query.list();
			session.close();
			return list;
		}
		@Transactional
		public void deleteCartItem(Cart cart)
		{
			sessionFactory.getCurrentSession().delete(cart);
		}
		

		public Cart getCartItem(int cartItemid)
		{
			Session session=sessionFactory.openSession();
			Cart cart=(Cart)session.get(Cart.class,cartItemid);
			return cart;
		}
	}
