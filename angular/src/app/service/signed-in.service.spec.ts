import { TestBed } from '@angular/core/testing';

import { SignedInService } from './signed-in.service';

describe('SignedInService', () => {
  let service: SignedInService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignedInService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
