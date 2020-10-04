import { Injectable } from '@angular/core';
import { Test } from '../model/test';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TestService {
    baseUrl = "http://localhost:8586/tests";
    constructor(private http: HttpClient) {

    }
    addTest(test: Test): Observable<Test> {
        let url = this.baseUrl + "/addtest";
        let observable: Observable<Test> = this.http.post<Test>(url, test);
        return observable;
    }

    getAllTests(): Observable<Test[]> {
        let url = "http://localhost:8586/tests";
        let observable: Observable<Test[]> = this.http.get<Test[]>(url);
        return observable;
    }
    getTest(id: number): Observable<Test> {
        let url = this.baseUrl + "/gettest/" + id;
        console.log("get id " + id);
        let observable: Observable<Test> = this.http.get<Test>(url);
        return observable;
    }


    removeTestById(id: number): Observable<void> {
        let url = this.baseUrl + "/deletetest/" + id;
        let observable: Observable<void> = this.http.delete<void>(url);
        return observable;
    }


}
