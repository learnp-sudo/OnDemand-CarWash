import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashermyordersComponent } from './washermyorders.component';

describe('WashermyordersComponent', () => {
  let component: WashermyordersComponent;
  let fixture: ComponentFixture<WashermyordersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashermyordersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashermyordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
