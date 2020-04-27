import { TestBed } from '@angular/core/testing';

import { PublicContestDetailsService } from './public-contest-details.service';

describe('PublicContestDetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PublicContestDetailsService = TestBed.get(PublicContestDetailsService);
    expect(service).toBeTruthy();
  });
});
