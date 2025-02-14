import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckLoginComponent } from './check-login.component';

describe('CheckLoginComponent', () => {
  let component: CheckLoginComponent;
  let fixture: ComponentFixture<CheckLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckLoginComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CheckLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
