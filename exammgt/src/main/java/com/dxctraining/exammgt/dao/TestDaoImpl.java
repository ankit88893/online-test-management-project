package com.dxctraining.exammgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.exammgt.entities.Test;
import com.dxctraining.exammgt.exceptions.TestNotFoundException;

@Repository
public class TestDaoImpl implements ITestDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Test findTestById(Integer id) {
		Test test = em.find(Test.class, id);
		if (test == null) {
			throw new TestNotFoundException("test not found for id :-" + id);

		}

		return test;

	}

	@Override

	public Test addTest(Test test) {
		em.persist(test);
		return test;

	}

	@Override
	public void removeTest(Integer id) {

		Test test = findTestById(id);
		em.remove(test);

	}

	@Override
	public List<Test> getAllTest() {
		String jq = "from Test";
		TypedQuery<Test> query = em.createQuery(jq, Test.class);
		List<Test> testList = query.getResultList();
		return testList;

	}

}