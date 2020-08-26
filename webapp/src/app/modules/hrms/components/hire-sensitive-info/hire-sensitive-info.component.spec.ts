import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HireSensitiveInfoComponent } from './hire-sensitive-info.component';

describe('HireSensitiveInfoComponent', () => {
  let component: HireSensitiveInfoComponent;
  let fixture: ComponentFixture<HireSensitiveInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HireSensitiveInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HireSensitiveInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
