import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAssignOrdersComponent } from './update-assign-orders.component';

describe('UpdateAssignOrdersComponent', () => {
  let component: UpdateAssignOrdersComponent;
  let fixture: ComponentFixture<UpdateAssignOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateAssignOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateAssignOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
