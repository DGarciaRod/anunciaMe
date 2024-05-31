import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputPrecioComponent } from './input-precio.component';

describe('InputFieldComponent', () => {
  let component: InputPrecioComponent;
  let fixture: ComponentFixture<InputPrecioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InputPrecioComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InputPrecioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
