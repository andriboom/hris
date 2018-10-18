import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PersonService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<any> {
      return this.http.get('//localhost:8080/person/');
      console.log("piste");
    }
}
