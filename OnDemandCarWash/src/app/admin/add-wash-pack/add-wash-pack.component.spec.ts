import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddWashPackComponent } from './add-wash-pack.component';

describe('AddWashPackComponent', () => {
  let component: AddWashPackComponent;
  let fixture: ComponentFixture<AddWashPackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddWashPackComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddWashPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
