import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAltaUsuarioComponent } from './form-alta-usuario.component';

describe('FormAltaUsuarioComponent', () => {
  let component: FormAltaUsuarioComponent;
  let fixture: ComponentFixture<FormAltaUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAltaUsuarioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormAltaUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
