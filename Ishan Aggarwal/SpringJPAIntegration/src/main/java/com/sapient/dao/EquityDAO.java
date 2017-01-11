package com.sapient.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.model.Equity;

@Repository("equityDAO")
public class EquityDAO {

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void saveEquity(Equity equity) {
		entityManager.persist(equity);
	}

	@Transactional
	public Equity getEquity(Integer equityId) {
		Equity equity = entityManager.find(Equity.class, equityId);
		// System.out.println(equity.toString());
		return equity;
	}

}
