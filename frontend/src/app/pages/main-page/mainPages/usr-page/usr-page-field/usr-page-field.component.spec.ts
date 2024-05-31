import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrPageFieldComponent } from './usr-page-field.component';

describe('UsrPageFieldComponent', () => {
  let component: UsrPageFieldComponent;
  let fixture: ComponentFixture<UsrPageFieldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsrPageFieldComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UsrPageFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
