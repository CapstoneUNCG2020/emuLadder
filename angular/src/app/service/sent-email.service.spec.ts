import { TestBed } from '@angular/core/testing';

import { SentEmailService } from './sent-email.service';

describe('SentEmailService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));
  let service: SentEmailService;
  it('should be created', () => {
    const service: SentEmailService = TestBed.get(SentEmailService);
    expect(service).toBeTruthy();
  });
});
