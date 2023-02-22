import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnassignOrdersComponent } from './unassign-orders.component';

describe('UnassignOrdersComponent', () => {
  let component: UnassignOrdersComponent;
  let fixture: ComponentFixture<UnassignOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnassignOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnassignOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
