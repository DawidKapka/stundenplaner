import { Component, OnInit } from '@angular/core';
import {Teacher} from '../interfaces/teacher';
import {SchoolModules} from "../interfaces/schoolModules";
import {SchoolModuleService} from "../services/school-module.service";

@Component({
  selector: 'app-lehrer-erfassen-component-template',
  templateUrl: './lehrer-erfassen-component-template.component.html',
  styleUrls: ['./lehrer-erfassen-component-template.component.scss']
})
export class LehrerErfassenComponentTemplateComponent implements OnInit {

  schoolTeacher: Teacher = {name: '', shortcut: '', pensum: 0, availableDays: [], modules: []};

  schoolModules: SchoolModules[] = this.schoolModuleService.getSchoolModules();

  isDropdownOpen: boolean = false;

  constructor(private schoolModuleService: SchoolModuleService) { }

  ngOnInit(): void {
  }

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  update($event: Event) {
    
  }
}
