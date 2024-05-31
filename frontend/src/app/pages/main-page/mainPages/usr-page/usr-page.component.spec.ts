import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsrPageComponent } from './usr-page.component';

describe('UsrPageComponent', () => {
  let component: UsrPageComponent;
  let fixture: ComponentFixture<UsrPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsrPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UsrPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
