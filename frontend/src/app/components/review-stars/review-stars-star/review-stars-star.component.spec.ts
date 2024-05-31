import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewStarsStarComponent } from './review-stars-star.component';

describe('ReviewStarsStarComponent', () => {
  let component: ReviewStarsStarComponent;
  let fixture: ComponentFixture<ReviewStarsStarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReviewStarsStarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ReviewStarsStarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
