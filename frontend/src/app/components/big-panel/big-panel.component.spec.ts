import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BigPanelComponent } from './big-panel.component';

describe('BigPanelComponent', () => {
  let component: BigPanelComponent;
  let fixture: ComponentFixture<BigPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BigPanelComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BigPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
