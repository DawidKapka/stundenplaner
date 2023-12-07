import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FaecherErfassenComponent } from './faecher-erfassen.component';

describe('FaecherErfassenComponent', () => {
  let component: FaecherErfassenComponent;
  let fixture: ComponentFixture<FaecherErfassenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FaecherErfassenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FaecherErfassenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
