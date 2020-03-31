import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InviteBarComponent } from './invite-bar.component';

describe('InviteBarComponent', () => {
  let component: InviteBarComponent;
  let fixture: ComponentFixture<InviteBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InviteBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InviteBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
