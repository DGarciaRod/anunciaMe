import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrButtonComponent } from './usr-button.component';

describe('UsrButtonComponent', () => {
  let component: UsrButtonComponent;
  let fixture: ComponentFixture<UsrButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsrButtonComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UsrButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
