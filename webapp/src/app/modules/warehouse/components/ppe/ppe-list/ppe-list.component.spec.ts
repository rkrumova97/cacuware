import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PpeListComponent } from './ppe-list.component';

describe('PpeListComponent', () => {
  let component: PpeListComponent;
  let fixture: ComponentFixture<PpeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PpeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PpeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
