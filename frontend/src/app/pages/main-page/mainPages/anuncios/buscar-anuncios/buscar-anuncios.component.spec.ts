import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarAnunciosComponent } from './buscar-anuncios.component';

describe('BuscarAnunciosComponent', () => {
  let component: BuscarAnunciosComponent;
  let fixture: ComponentFixture<BuscarAnunciosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarAnunciosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuscarAnunciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
