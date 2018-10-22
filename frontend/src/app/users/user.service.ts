import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

      getUsers() {
        return this.http.get('http://localhost:8080/person/')
      }

      createUser(user) {
        return this.http.post('http://localhost:8080/person/create',user)
      }

      updateUser(user) {
        return this.http.post('http://localhost:8080/person/update/' + user.id,user)
      }
}
