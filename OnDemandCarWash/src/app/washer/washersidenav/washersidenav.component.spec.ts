import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashersidenavComponent } from './washersidenav.component';

describe('WashersidenavComponent', () => {
  let component: WashersidenavComponent;
  let fixture: ComponentFixture<WashersidenavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashersidenavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashersidenavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
