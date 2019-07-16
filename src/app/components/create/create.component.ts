import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { PersonService } from '../../person.service';
import { FormGroup,  FormBuilder,  Validators } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  title = 'Add Person';
  angForm: FormGroup;
  constructor(private personservice: PersonService, private fb: FormBuilder, private router: Router) {
    this.createForm();
   }
  createForm() {
    this.angForm = this.fb.group({
      name: ['', Validators.required ],
      age: ['', Validators.required ]
   });
  }
  addPerson(first_name, last_name,age,favourite_colour,hobby) {
      this.personservice.addPerson(first_name, last_name,age,favourite_colour,hobby);
      this.router.navigate(['index']);
  }
  ngOnInit() {
  }
}
