import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WasherregisterComponent } from './washerregister.component';

describe('WasherregisterComponent', () => {
  let component: WasherregisterComponent;
  let fixture: ComponentFixture<WasherregisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WasherregisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WasherregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
