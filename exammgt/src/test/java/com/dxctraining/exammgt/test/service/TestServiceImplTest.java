package com.dxctraining.exammgt.test.service;


import com.dxctraining.exammgt.dao.*;
import com.dxctraining.exammgt.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.dxctraining.exammgt.exceptions.*;
import com.dxctraining.exammgt.service.ITestService;
import com.dxctraining.exammgt.service.TestServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import({TestServiceImpl.class, TestDaoImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestServiceImplTest {

    @Autowired
    private ITestService service;

    @Autowired
    private EntityManager entityManager;

    /**
     * case/scenario: department does NOT exist in the store
     * verifying: DepartmentNotFoundException is thrown
     */
    @Test
    public void testFindById_1() {
     /*
       Executable executable=new Executable() {
         @Override
         public void execute() throws Throwable {
             service.findById(768);
         }
     };
     */
        Executable executable = () -> service.findTestById(768);
        Assertions.assertThrows(TestNotFoundException.class, executable);

    }

   
// 			@Test
//    		public void testFindById_2() {
//    		 System.out.println("entity manager=" + entityManager);
//       	 Test test = new Test();
//       	 test.setTestTitle("java");
//       	 test = entityManager.merge(test);
//       	 int testId = test.getId();
//      	  Test result = service.findTestById(testId);
//       	 Assertions.assertEquals(testId, result.getId());
//       	 Assertions.assertEquals(test.getTestTitle(), result.getTestTitle());
//    }

   
}
