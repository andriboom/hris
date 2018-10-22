import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  users$: Object;
  public firstName: firstName = "";
  public lastName: lastName = "";
  public emailAddress: emailAddress = "";

  constructor(private data: UserService) { }

  ngOnInit() {
      this.data.getUsers().subscribe(
        data => this.users$ = data
      );
    }

  createUser() {
    const person = {
        firstName: this.firstName,
        lastName: this.lastName,
        emailAddress: this.emailAddress
    };
    this.data.createUser(person).subscribe();
  }

}
