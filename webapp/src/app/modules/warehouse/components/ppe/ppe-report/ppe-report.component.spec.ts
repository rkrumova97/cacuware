import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PpeReportComponent } from './ppe-report.component';

describe('PpeReportComponent', () => {
  let component: PpeReportComponent;
  let fixture: ComponentFixture<PpeReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PpeReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PpeReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
