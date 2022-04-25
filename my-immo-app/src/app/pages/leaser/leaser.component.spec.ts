import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaserComponent } from './leaser.component';

describe('LeaserComponent', () => {
  let component: LeaserComponent;
  let fixture: ComponentFixture<LeaserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LeaserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
