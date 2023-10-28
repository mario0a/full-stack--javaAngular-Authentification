import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BienvenueContentComponent } from './bienvenue-content.component';

describe('BienvenueContentComponent', () => {
  let component: BienvenueContentComponent;
  let fixture: ComponentFixture<BienvenueContentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BienvenueContentComponent]
    });
    fixture = TestBed.createComponent(BienvenueContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
