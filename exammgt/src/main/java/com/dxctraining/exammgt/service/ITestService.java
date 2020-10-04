package com.dxctraining.exammgt.service;

import java.util.List;

import com.dxctraining.exammgt.entities.Test;

public interface ITestService {

	void removeTest(Integer id);

	Test addTest(Test test);

	Test findTestById(Integer id);

	List<Test> findAlltest();

}
