import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.sass']
})
export class FormComponent implements OnInit {

  form: FormGroup;

  constructor(private readonly fb: FormBuilder) {
    
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      nombre: [''],
      apellido: [''],
      email: ['']
     
  });
}
  onSubmit():void {
    console.log(this.form.value);

}
onClickLimpiar():void {
  this.form.reset();
}

}
