import { PersonService } from '../person.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {
  people: Array<any>;

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.findAll().subscribe(data => {
          this.people = data;
        });
  }
}
