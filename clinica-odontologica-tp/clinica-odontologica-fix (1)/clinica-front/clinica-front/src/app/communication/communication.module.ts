import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OdontologosComponent } from './odontologos/odontologos.component';
import { PacientesComponent } from './pacientes/pacientes.component';
import { TurnosComponent } from './turnos/turnos.component';



@NgModule({
  declarations: [
    OdontologosComponent,
    PacientesComponent,
    TurnosComponent
  ],
  imports: [
    CommonModule
  ]
})
export class CommunicationModule { }
