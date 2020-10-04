import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Test } from '../model/test';
import { TestService } from '../service/testservice';

@Component({
  selector: 'app-testlist',
  templateUrl: './testlist.component.html',
  styleUrls: ['./testlist.component.css']
})
export class TestlistComponent {


  tests: Test[];

  constructor(private testService: TestService) {
    let observable: Observable<Test[]> = testService.getAllTests();
    observable.subscribe(
      testArr => {
        this.tests = testArr;
      },
      err => {
        console.log("inside TestListComponent err is " + err.message);
      }

    );
  }

  removeTest(id: number) {
    let observable = this.testService.removeTestById(id);
    observable.subscribe(
      res => {
        this.removeLocalElement(id);
      },
      err => {
        console.log("inside removetest, err is " + err.message);
      }
    );
  }

  removeLocalElement(id: number): void {
    console.log("before test removed,length=" + this.tests.length);
    for (let i = 0; i < this.tests.length; i++) {
      let test = this.tests[i];
      if (test.id === id) {
        //index and number of elements to remove
        this.tests.splice(i, 1);
      }
    }

  }
}