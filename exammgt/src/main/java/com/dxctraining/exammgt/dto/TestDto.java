package com.dxctraining.exammgt.dto;

public class TestDto {

	private Integer id;
	private String testTitle;
	private String testDuration;
	private double testTotalMark;
	private double testMarkScored;
	private String startTime;
	private String endTime;

	public TestDto() {

	}

	public TestDto(Integer id, String testTitle, String testDuration, double testTotalMark, double testMarkScored,
			String startTime, String endTime) {
		this.endTime = endTime;
		this.id = id;
		this.startTime = startTime;
		this.testDuration = testDuration;
		this.testMarkScored = testMarkScored;
		this.testTitle = testTitle;
		this.testTotalMark=testTotalMark;
	

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(String testDuration) {
		this.testDuration = testDuration;
	}

	public double getTestTotalMark() {
		return testTotalMark;
	}

	public void setTestTotalMark(double testTotalMark) {
		this.testTotalMark = testTotalMark;
	}

	public double getTestMarkScored() {
		return testMarkScored;
	}

	public void setTestMarkScored(double testMarkScored) {
		this.testMarkScored = testMarkScored;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
