import { Component, OnInit } from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";

@Component({
  selector: 'app-faecher-erfassen-component-template',
  templateUrl: './faecher-erfassen-component-template.component.html',
  styleUrls: ['./faecher-erfassen-component-template.component.scss']
})
export class FaecherErfassenComponentTemplateComponent implements OnInit {

  schoolModule: SchoolModules = {name: '', shortcut: ''};

  constructor() { }

  ngOnInit(): void {
  }
}
