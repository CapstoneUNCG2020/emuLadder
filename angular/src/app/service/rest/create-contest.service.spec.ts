import { TestBed } from '@angular/core/testing';

import { CreateContestService } from './create-Contest.service';

describe('CreateContestService', () => {
  let service: CreateContestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateContestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
