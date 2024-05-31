import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LabelAndValueComponent } from './label-and-value.component';

describe('LabelAndValueComponent', () => {
  let component: LabelAndValueComponent;
  let fixture: ComponentFixture<LabelAndValueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LabelAndValueComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LabelAndValueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
