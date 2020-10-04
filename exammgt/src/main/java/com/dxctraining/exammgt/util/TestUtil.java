package com.dxctraining.exammgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.exammgt.dto.TestDto;
import com.dxctraining.exammgt.entities.Test;

@Component
public class TestUtil {
	
	public TestDto testDto(Test test) {
		TestDto dto = new TestDto(test.getId(),test.getTestTitle(),test.getTestDuration(), test.getTestTotalMark(),
				test.getTestMarkScored(),test.getStartTime(),test.getEndTime());
		return dto;
		
		
	}

}
