import { Component, OnInit } from '@angular/core';
import {SchoolClass} from '../interfaces/schoolClass';

@Component({
  selector: 'app-klasse-erfassen-component-template',
  templateUrl: './klasse-erfassen-component-template.component.html',
  styleUrls: ['./klasse-erfassen-component-template.component.scss']
})
export class KlasseErfassenComponentTemplateComponent implements OnInit {

  schoolClass: SchoolClass = {name: '', daysAvailable: [], modules: [], hasBasislehrjahr: false};

  constructor() { }

  ngOnInit(): void {
  }

}
