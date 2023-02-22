import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnassignedOrderComponent } from './unassigned-order.component';

describe('UnassignedOrderComponent', () => {
  let component: UnassignedOrderComponent;
  let fixture: ComponentFixture<UnassignedOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnassignedOrderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnassignedOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
