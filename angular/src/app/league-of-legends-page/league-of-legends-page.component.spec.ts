import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeagueOfLegendsPageComponent } from './league-of-legends-page.component';

describe('LeagueOfLegendsPageComponent', () => {
  let component: LeagueOfLegendsPageComponent;
  let fixture: ComponentFixture<LeagueOfLegendsPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeagueOfLegendsPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeagueOfLegendsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
