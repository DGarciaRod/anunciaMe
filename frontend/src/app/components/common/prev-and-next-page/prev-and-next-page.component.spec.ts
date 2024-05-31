import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrevAndNextPageComponent } from './prev-and-next-page.component';

describe('PrevAndNextPageComponent', () => {
  let component: PrevAndNextPageComponent;
  let fixture: ComponentFixture<PrevAndNextPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrevAndNextPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PrevAndNextPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
