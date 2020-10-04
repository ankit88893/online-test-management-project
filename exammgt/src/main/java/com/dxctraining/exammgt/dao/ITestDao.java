package com.dxctraining.exammgt.dao;

import java.util.List;

import com.dxctraining.exammgt.entities.Test;

public interface ITestDao {



	Test findTestById(Integer id);

	Test addTest(Test test);

	void removeTest(Integer id);

	List<Test> getAllTest();
	

}
