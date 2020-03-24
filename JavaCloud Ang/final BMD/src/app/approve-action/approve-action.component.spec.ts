import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveActionComponent } from './approve-action.component';

describe('ApproveActionComponent', () => {
  let component: ApproveActionComponent;
  let fixture: ComponentFixture<ApproveActionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveActionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveActionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
