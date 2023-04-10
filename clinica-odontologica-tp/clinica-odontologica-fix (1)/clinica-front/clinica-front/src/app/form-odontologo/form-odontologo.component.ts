import { Component, OnInit } from '@angular/core';



import { FormGroup,FormBuilder,Validators } from '@angular/forms';

@Component({
  selector: 'app-form-odontologo',
  templateUrl: './form-odontologo.component.html',
  styleUrls: ['./form-odontologo.component.scss']
})
export class FormOdontologoComponent implements OnInit {

  public formOdontologo: FormGroup;

  constructor(private formBuild:FormBuilder) {
    this.formOdontologo = this.formBuild.group({
      nombre:['',Validators.required],
      apellido:['',Validators.required],
      matricula:['',Validators.required]
    });


   }

  ngOnInit(): void {
    this.initForm();

  }

  initForm(){
    this.formOdontologo = this.formBuild.group({
      nombre:['',Validators.required],
      apellido:['',Validators.required],
      matricula:['',Validators.required],
      especialidad:['',Validators.required],
      telefono:['',Validators.required],
      email:['',Validators.required],
      direccion:['',Validators.required]
    });
  }

  get f(){
    return this.formOdontologo.controls;
  }

}
