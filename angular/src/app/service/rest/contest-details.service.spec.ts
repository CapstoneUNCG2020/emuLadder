import { TestBed } from '@angular/core/testing';

import { ContestDetailsService } from './contest-details.service';

describe('ContestDetailsService', () => {
  let service: ContestDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContestDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
