import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HireEmployeeDetailsComponent } from './hire-employee-details.component';

describe('HireEmployeeDetailsComponent', () => {
  let component: HireEmployeeDetailsComponent;
  let fixture: ComponentFixture<HireEmployeeDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HireEmployeeDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HireEmployeeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
