import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormConsultarComponent } from './form.component';

describe('FormComponent', () => {
  let component: FormConsultarComponent;
  let fixture: ComponentFixture<FormConsultarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormConsultarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormConsultarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
