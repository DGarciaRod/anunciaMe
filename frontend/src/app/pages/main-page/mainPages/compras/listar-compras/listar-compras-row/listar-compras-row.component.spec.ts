import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarComprasRowComponent } from './listar-compras-row.component';

describe('ListarComprasRowComponent', () => {
  let component: ListarComprasRowComponent;
  let fixture: ComponentFixture<ListarComprasRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarComprasRowComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarComprasRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
