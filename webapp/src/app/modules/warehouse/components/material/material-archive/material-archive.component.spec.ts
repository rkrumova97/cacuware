import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterialArchiveComponent } from './material-archive.component';

describe('MaterialArchiveComponent', () => {
  let component: MaterialArchiveComponent;
  let fixture: ComponentFixture<MaterialArchiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaterialArchiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaterialArchiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
