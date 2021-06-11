package br.com.fiap.dao;

import br.com.fiap.model.Register;
import br.com.fiap.model.Setup;
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
		return manager.find(Register.class, id);
	}

	public void update(Setup setup) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(setup);
		manager.flush();
		manager.getTransaction().commit();

		manager.close();
	}
}
