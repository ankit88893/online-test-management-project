import { Component } from '@angular/core';
// import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { Test } from '../model/test'
import { TestService } from '../service/testservice';

@Component({
  selector: 'app-testdetails',
  templateUrl: './testdetails.component.html',
  styleUrls: ['./testdetails.component.css']
})
export class TestdetailsComponent {

  constructor(private testService:TestService) { 
  
  }
  test:Test;




  findTest(form:any){
    let data=form.value;
    let id=data.testid;
    let observable:Observable<Test>= this.testService.getTest(id);
    observable.subscribe(
      testArg=>{this.test=testArg},
      error=>{
        console.log("error inside test details component"+error.message)
      }
    );
     
   }

}




































 // constructor(private route: ActivatedRoute, private testService: TestService) {
  //   let observable =route.paramMap;//param map is the property in activated route
  //   observable.subscribe((params:ParamMap)=>{
  //    let idVal:string =params.get("id");
  //    let idNum:number=Number(idVal);//converting string to number
  //    console.log("id available is "+idNum);
  //    this.findTestById(idNum);
  //   })
  //   }

  //   test:Test;


  //   findTestById(id:number){
  //    let observable:Observable<Test>=this.testService.getTest(id);
  //    observable.subscribe(
  //      testArg=>{
  //        this.test=testArg;
  //      },

  //      err=>{
  //        console.log("inside  test details, err is "+err.message);
  //      }

  //    );
  //   }

  //  findTest(form:any){
  //    let data=form.value;
  //    let id=data.testid;
  //   this.findTestById(id);
  //  }
//}
