package com.dxctraining.exammgt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.exammgt.dao.ITestDao;
import com.dxctraining.exammgt.entities.Test;
import com.dxctraining.exammgt.exceptions.InvalidArgumentException;

@Transactional
@Service
public class TestServiceImpl implements ITestService {

	private static final Logger Log = LoggerFactory.getLogger(TestServiceImpl.class);

	@Autowired
	ITestDao dao;

	public void validate(Test test) {
		if (test == null) {
			throw new InvalidArgumentException("test can't be null");
		}
	}

	@Override

	public Test findTestById(Integer id) {
		Log.info("***service class,inside findTestById ,id=" + id);
		Test test = dao.findTestById(id);
		return test;

	}

	@Override
	public Test addTest(Test test) {
		validate(test);
		test = dao.addTest(test);
		return test;

	}

	@Override
	public void removeTest(Integer id) {
		dao.removeTest(id);

	}

	@Override

	public List<Test> findAlltest() {
		List<Test> allTestList = dao.getAllTest();
		return allTestList;
	}

}
