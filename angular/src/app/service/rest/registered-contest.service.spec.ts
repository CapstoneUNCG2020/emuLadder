import { TestBed } from '@angular/core/testing';

import { RegisteredContestService } from './registered-contest.service';

describe('RegisteredContestService', () => {
  let service: RegisteredContestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisteredContestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
