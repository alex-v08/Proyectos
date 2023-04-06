import { Component, OnInit } from '@angular/core';
import { AbstractControl } from '@angular/forms';
import { FormGroup, FormControl,FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  
  form : FormGroup;

  get nombreCtrl(): AbstractControl{
    return this.form.get('nombre')?.value;
  }
  


  constructor(private readonly fb: FormBuilder) {
    this.form = this.fb.group({
      id: [''],
      nombre: [''],
      apellido: [''],
      matricula: ['']
  
   });
  }

  ngOnInit(): void {
  }
  onSubmit():void{
    console.log(this.form.value);
  }
  onReset():void{
    
  this.form.reset();

  }
     
    }
  



