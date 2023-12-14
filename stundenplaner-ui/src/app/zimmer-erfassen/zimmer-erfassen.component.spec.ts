import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZimmerErfassenComponent } from './zimmer-erfassen.component';

describe('ZimmerErfassenComponent', () => {
  let component: ZimmerErfassenComponent;
  let fixture: ComponentFixture<ZimmerErfassenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZimmerErfassenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZimmerErfassenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
