package br.com.fiap.dao;

import br.com.fiap.model.Register;
import br.com.fiap.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

	public Register findById(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		Register register = null;
		try {
			register = manager.find(Register.class, id);
		} finally {
			manager.close();
		}
		return register;
	}

	public void update(Register register) {
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(register);
			manager.flush();
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}

	public void delete(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			manager.getTransaction().begin();
			Register register = manager.find(Register.class, id);
			manager.remove(register);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}

}
