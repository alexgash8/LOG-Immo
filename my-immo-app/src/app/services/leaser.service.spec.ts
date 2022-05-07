import { TestBed } from '@angular/core/testing';

import { LeaserService } from './leaser.service';

describe('LeaserService', () => {
  let service: LeaserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeaserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
