import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PpeProfileComponent } from './ppe-profile.component';

describe('PpeProfileComponent', () => {
  let component: PpeProfileComponent;
  let fixture: ComponentFixture<PpeProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PpeProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PpeProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
