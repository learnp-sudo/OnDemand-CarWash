import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WasherWashPackComponent } from './washer-wash-pack.component';

describe('WasherWashPackComponent', () => {
  let component: WasherWashPackComponent;
  let fixture: ComponentFixture<WasherWashPackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WasherWashPackComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WasherWashPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
