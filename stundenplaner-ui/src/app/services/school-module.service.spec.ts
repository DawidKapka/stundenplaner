import { TestBed } from '@angular/core/testing';

import { SchoolModuleService } from './school-module.service';

describe('SchoolModuleService', () => {
  let service: SchoolModuleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SchoolModuleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
