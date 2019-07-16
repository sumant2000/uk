import { Injectable } from '@angular/core';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class PersonService {

  result: any;
  constructor(private http: HttpClient) {}

  addPerson(first_name: any, last_name: any,age: any,favourite_colour: any,hobby: any) {
    const uri = 'http://localhost:8080/users/persons/create';
    const obj = {
      first_name: first_name,
      last_name: last_name,
      age: age,
      favourite_colour: favourite_colour,
      hobby: hobby
    };
    this
      .http
      .post(uri, obj)
      .subscribe(res =>
          console.log('Done'));
  }

  getPersons() {
    const uri = 'http://localhost:8080/users/list';
    return this
            .http
            .get(uri)
            .map(res => {
              return res;
            });
  }

  editPerson(personId) {
    const uri = 'http://localhost:8080/users/update/persons/' + personId;
    return this
            .http
            .get(uri)
            .map(res => {
              return res;
            });
  }

  updatePerson(first_name, last_name,age,favourite_colour,hobby, personId) {
    const uri = 'http://localhost:8080/users/update/persons/' + personId;

    const obj = {
      first_name: first_name,
      last_name: last_name,
      age: age,
      favourite_colour: favourite_colour,
      hobby: hobby,
      personId: personId
    };
    this
      .http
      .post(uri, obj)
      .subscribe(res => console.log('Done'));
  }

  deletePerson(personId) {
    const uri = 'http://localhost:8080/users/delete/persons/' + personId;

        return this
            .http
            .get(uri)
            .map(res => {
              return res;
            });
  }
}
