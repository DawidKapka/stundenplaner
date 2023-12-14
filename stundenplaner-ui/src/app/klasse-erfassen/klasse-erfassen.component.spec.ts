import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KlasseErfassenComponent } from './klasse-erfassen.component';

describe('KlasseErfassenComponent', () => {
  let component: KlasseErfassenComponent;
  let fixture: ComponentFixture<KlasseErfassenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KlasseErfassenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KlasseErfassenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
