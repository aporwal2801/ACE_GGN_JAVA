package com.sapient.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.EquityDAO;
import com.sapient.model.Equity;

@Service
public class EquityService {

	private Equity equity = null;
	@Autowired
	private EquityDAO equityDAO;

	@Transactional
	public void add(Equity equity) {
		equityDAO.saveEquity(equity);
	}

	@Transactional
	public void addAll(Collection<Equity> equities) {
		for (Equity equity : equities) {
			equityDAO.saveEquity(equity);
		}
	}

	@Transactional(readOnly = true)
	public void getEquityById(Integer id) {
		equity = equityDAO.getEquity(id);
		System.out.println(equity.toString());
	}
}
