import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PpeArchiveComponent } from './ppe-archive.component';

describe('PpeArchiveComponent', () => {
  let component: PpeArchiveComponent;
  let fixture: ComponentFixture<PpeArchiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PpeArchiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PpeArchiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
