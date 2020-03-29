import { TestBed } from '@angular/core/testing';

import { BackendCheckService } from './backend-check.service';

describe('BackendCheckService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BackendCheckService = TestBed.get(BackendCheckService);
    expect(service).toBeTruthy();
  });
});
