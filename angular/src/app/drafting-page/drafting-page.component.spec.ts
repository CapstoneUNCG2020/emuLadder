import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DraftingPageComponent } from './drafting-page.component';

describe('DraftingPageComponent', () => {
  let component: DraftingPageComponent;
  let fixture: ComponentFixture<DraftingPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DraftingPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DraftingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
