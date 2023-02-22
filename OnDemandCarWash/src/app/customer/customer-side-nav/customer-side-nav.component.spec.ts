import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerSideNavComponent } from './customer-side-nav.component';

describe('CustomerSideNavComponent', () => {
  let component: CustomerSideNavComponent;
  let fixture: ComponentFixture<CustomerSideNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerSideNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerSideNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
