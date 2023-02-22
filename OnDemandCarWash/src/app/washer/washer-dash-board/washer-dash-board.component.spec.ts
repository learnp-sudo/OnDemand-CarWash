import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WasherDashBoardComponent } from './washer-dash-board.component';

describe('WasherDashBoardComponent', () => {
  let component: WasherDashBoardComponent;
  let fixture: ComponentFixture<WasherDashBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WasherDashBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WasherDashBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
