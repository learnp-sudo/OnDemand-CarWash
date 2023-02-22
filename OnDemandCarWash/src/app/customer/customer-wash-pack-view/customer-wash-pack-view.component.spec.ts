import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerWashPackViewComponent } from './customer-wash-pack-view.component';

describe('CustomerWashPackViewComponent', () => {
  let component: CustomerWashPackViewComponent;
  let fixture: ComponentFixture<CustomerWashPackViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerWashPackViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerWashPackViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
