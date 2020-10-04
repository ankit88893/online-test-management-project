export class Test{
  id:number;
  testTitle:string;
  testDuration:string;
  testTotalMark:number;
  testMarkScored:number;
  startTime:string;
  endTime:string


  constructor( id:number, testTitle:string, testDuration:string, testTotalMark:number, 
    testMarkScored:number, startTime:string,endTime:string ){
      this.endTime=endTime;
       this.id=id;
      this.testTotalMark=testTotalMark;
      this.startTime=startTime;
      this.testDuration=testDuration;
      this.testTitle=testTitle;
      this.testMarkScored=testMarkScored;

    }
    getTestTitle():string{
      return this.testTitle;
    }
    getTestDuration():string{
      return this.testDuration;
    }
    // getTotalMarks():number{
    //   return this.totalMarks;
    // }
    // getMarksScored():number{
    //   return this.marksScored;
    // }
    getStartTime():string{
      return this.startTime;
    }
    getEndTime():string{
      return this.endTime;
    }
  
} 