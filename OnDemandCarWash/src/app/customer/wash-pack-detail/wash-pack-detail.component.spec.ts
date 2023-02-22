import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashPackDetailComponent } from './wash-pack-detail.component';

describe('WashPackDetailComponent', () => {
  let component: WashPackDetailComponent;
  let fixture: ComponentFixture<WashPackDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashPackDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashPackDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
