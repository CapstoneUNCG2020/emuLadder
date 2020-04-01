import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScoringRosterBreakdownComponent } from './scoring-roster-breakdown.component';

describe('ScoringRosterBreakdownComponent', () => {
  let component: ScoringRosterBreakdownComponent;
  let fixture: ComponentFixture<ScoringRosterBreakdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScoringRosterBreakdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScoringRosterBreakdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
