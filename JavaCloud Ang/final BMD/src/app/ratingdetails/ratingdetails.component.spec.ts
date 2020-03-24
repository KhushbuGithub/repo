import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RatingdetailsComponent } from './ratingdetails.component';

describe('RatingdetailsComponent', () => {
  let component: RatingdetailsComponent;
  let fixture: ComponentFixture<RatingdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RatingdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
