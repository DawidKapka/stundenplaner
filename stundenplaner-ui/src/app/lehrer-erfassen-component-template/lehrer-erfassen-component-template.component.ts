import { Component, OnInit } from '@angular/core';
import {Teacher} from '../interfaces/teacher';

@Component({
  selector: 'app-lehrer-erfassen-component-template',
  templateUrl: './lehrer-erfassen-component-template.component.html',
  styleUrls: ['./lehrer-erfassen-component-template.component.scss']
})
export class LehrerErfassenComponentTemplateComponent implements OnInit {

  schoolTeacher: Teacher = {name: '', shortcut: '', pensum: 0, availableDays: [], modules: []};

  constructor() { }

  ngOnInit(): void {
  }

}
