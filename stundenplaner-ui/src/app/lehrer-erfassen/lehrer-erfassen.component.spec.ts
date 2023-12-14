import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LehrerErfassenComponent } from './lehrer-erfassen.component';

describe('LehrerErfassenComponent', () => {
  let component: LehrerErfassenComponent;
  let fixture: ComponentFixture<LehrerErfassenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LehrerErfassenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LehrerErfassenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
