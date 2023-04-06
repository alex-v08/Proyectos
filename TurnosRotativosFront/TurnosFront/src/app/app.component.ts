import { Component } from '@angular/core';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'Turnos Front';
  mostrar= true;
  frase: any = {
    mensaje: 'Un gran poder requiere una gran responsabilidad',
    autor: 'Ben Parker'
  };

  personajes: string[] = ['Spiderman', 'Venom', 'Dr. Octopus', 'Electro'];


}
