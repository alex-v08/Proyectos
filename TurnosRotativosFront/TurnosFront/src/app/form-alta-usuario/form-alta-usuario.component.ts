import { Component } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormAltaUsuarioComponent implements OnInit {
  
  form: FormGroup;


  constructor() {}

  ngOnInit(): void {}
  onSubmit(): void {}
}
