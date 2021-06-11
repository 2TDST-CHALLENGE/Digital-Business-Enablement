package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Register;
import br.com.fiap.utils.JPAUtil;

public class RegisterDAO {

	public void save(Register register) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(register);
		manager.getTransaction().commit();
		
		manager.close();
		
	}

	public List<Register> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT s FROM Register s";
		TypedQuery<Register> query = manager.createQuery(jpql, Register.class);
		return query.getResultList();		
	}
	
	
	
	
	
	
	
	
	
	
	

}
