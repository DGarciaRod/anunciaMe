import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReviewsAnuncioComponent } from './reviews-anuncio.component';

describe('ReviewsAnuncioComponent', () => {
  let component: ReviewsAnuncioComponent;
  let fixture: ComponentFixture<ReviewsAnuncioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReviewsAnuncioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ReviewsAnuncioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
