import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterialProfileComponent } from './material-profile.component';

describe('MaterialProfileComponent', () => {
  let component: MaterialProfileComponent;
  let fixture: ComponentFixture<MaterialProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaterialProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaterialProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
