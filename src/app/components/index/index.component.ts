import { PersonService } from './../../person.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Person } from '../../Person';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  persons: any;

  constructor(private http: HttpClient, private service: PersonService) {}

  ngOnInit() {
    this.getPersons();
  }

  getPersons() {
    this.service.getPersons().subscribe(res => {
      this.persons = res;
    });
  }

  deletePerson(id) {
    this.service.deletePerson(id).subscribe(res => {
      console.log('Deleted');
    });
  }
}
