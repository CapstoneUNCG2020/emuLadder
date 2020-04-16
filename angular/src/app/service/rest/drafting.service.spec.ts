import { TestBed } from '@angular/core/testing';

import { DraftingService } from './drafting.service';

describe('DraftingService', () => {
  let service: DraftingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DraftingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
