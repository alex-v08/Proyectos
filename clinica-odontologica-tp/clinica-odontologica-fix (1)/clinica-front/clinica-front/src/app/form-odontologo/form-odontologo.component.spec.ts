import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormOdontologoComponent } from './form-odontologo.component';

describe('FormOdontologoComponent', () => {
  let component: FormOdontologoComponent;
  let fixture: ComponentFixture<FormOdontologoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormOdontologoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormOdontologoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
