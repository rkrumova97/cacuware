import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PpeAddComponent } from './ppe-add.component';

describe('PpeAddComponent', () => {
  let component: PpeAddComponent;
  let fixture: ComponentFixture<PpeAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PpeAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PpeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
