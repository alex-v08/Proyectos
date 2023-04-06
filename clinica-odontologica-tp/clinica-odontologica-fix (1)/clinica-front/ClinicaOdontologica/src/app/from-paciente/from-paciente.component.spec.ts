import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FromPacienteComponent } from './from-paciente.component';

describe('FromPacienteComponent', () => {
  let component: FromPacienteComponent;
  let fixture: ComponentFixture<FromPacienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FromPacienteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FromPacienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
