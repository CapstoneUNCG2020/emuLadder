import { TestBed } from '@angular/core/testing';

import { SendEmailService } from './send-email.service';

describe('SendEmailService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SendEmailService = TestBed.get(SendEmailService);
    expect(service).toBeTruthy();
  });
});
