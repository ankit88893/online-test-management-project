package com.dxctraining.exammgt.controllers;

import java.util.ArrayList;  
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.exammgt.dto.CreateTestRequest;
import com.dxctraining.exammgt.dto.TestDto;
import com.dxctraining.exammgt.entities.Test;
import com.dxctraining.exammgt.service.ITestService;
import com.dxctraining.exammgt.util.TestUtil;
@Validated
@RestController
@RequestMapping("/tests")
public class RestExamController {
	
	private static final Logger Log = LoggerFactory.getLogger(RestExamController.class);


	@Autowired
	private TestUtil util;

	@Autowired
	private ITestService service;

	@Autowired
	private RestTemplate rest;

	@PostMapping(value = "/addtest")
	@ResponseStatus(HttpStatus.CREATED)
	public TestDto create(@RequestBody @Valid @NotNull CreateTestRequest data) {
		//public TestDto create(@RequestBody  CreateTestRequest data) {
		Log.info("test is added in the exam form");
		String testTitle = data.getTestTitle();
		String testDuration = data.getTestDuration();
		String endTime = data.getEndTime();
		String startTime = data.getStartTime();
		double testTotalMark = data.getTestTotalMark();
		double testMarkScored = data.getTestMarkScored();

		Test test = new Test(testTitle, testDuration, testTotalMark, testMarkScored, startTime, endTime);
		test = service.addTest(test);
		// for integration
		TestDto response = util.testDto(test);
		return response;

	}

	@GetMapping("/gettest/{id}")
	public TestDto findTest( @Valid @NotNull @PathVariable("id")  Integer id) {
		//public TestDto findTest(@PathVariable("id")   Integer id) {
		Test test = service.findTestById(id);
		// for integration
		TestDto response = util.testDto(test);
		return response;

	}

	@GetMapping()
	public List<TestDto> fetchAllTest() {
		List<Test> list = service.findAlltest();
		List<TestDto> response = new ArrayList();
		for (Test test : list) {
			TestDto dto = util.testDto(test);
			response.add(dto);
		}
		return response;

	}

	@DeleteMapping("/deletetest/{id}")
//	public void deleteTestById(@PathVariable @NotBlank Integer id) {
		public void deleteTestById(@PathVariable  Integer id) {
		Log.info("deleted test id is:-"+id);
		service.removeTest(id);
		
		
		
	}
/*
	@GetMapping("/deleteById/{id}")
	public Integer deleteTestById1(@PathVariable int id) {
		Integer deleted = service.removeTest(id);
		return deleted;
	}
*/
}
