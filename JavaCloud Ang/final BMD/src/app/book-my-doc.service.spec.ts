import { TestBed } from '@angular/core/testing';

import { BookMyDocService } from './book-my-doc.service';

describe('BookMyDocService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookMyDocService = TestBed.get(BookMyDocService);
    expect(service).toBeTruthy();
  });
});
