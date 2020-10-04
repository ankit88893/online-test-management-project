import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Test } from '../model/test';
import { TestService } from '../service/testservice';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-addtest',
  templateUrl: './addtest.component.html',
  styleUrls: ['./addtest.component.css']
})
export class AddtestComponent  {

  constructor(private testService: TestService) {

  }
  test: Test;



  addTest(form: any) {
    let data = form.value;
    let testTitle = data.testTitle;
    let testDuration = data.testDuration;
    let testTotalMark = data.testTotalMark;
    let testMarkScored = data.testMarkScored;
    let startTime = data.startTime;
    let endTime = data.endTime;

    this.test = new Test(1, testTitle, testDuration, testTotalMark, testMarkScored, startTime, endTime);
    let successFun = (testArg: Test) => {
      this.test = testArg;
    };

    let errFun = err => {
      console.log("err in addtestcomponent " + err.message);
    }

    let observable: Observable<Test> = this.testService.addTest(this.test);
    observable.subscribe(successFun, errFun);
    // alert(" Added sucessfully ");
    
  }
}

