import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerMyOrdersComponent } from './customer-my-orders.component';

describe('CustomerMyOrdersComponent', () => {
  let component: CustomerMyOrdersComponent;
  let fixture: ComponentFixture<CustomerMyOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerMyOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerMyOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
