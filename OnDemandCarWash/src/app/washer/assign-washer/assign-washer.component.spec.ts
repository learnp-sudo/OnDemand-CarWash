import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignWasherComponent } from './assign-washer.component';

describe('AssignWasherComponent', () => {
  let component: AssignWasherComponent;
  let fixture: ComponentFixture<AssignWasherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignWasherComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignWasherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
