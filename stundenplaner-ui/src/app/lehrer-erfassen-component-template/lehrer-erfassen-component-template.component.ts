import { Component, OnInit } from '@angular/core';
import {Teacher} from '../interfaces/teacher';
import {SchoolModules} from "../interfaces/schoolModules";
import {SchoolModuleService} from "../services/school-module.service";
import {Days} from "../enums/days";

@Component({
  selector: 'app-lehrer-erfassen-component-template',
  templateUrl: './lehrer-erfassen-component-template.component.html',
  styleUrls: ['./lehrer-erfassen-component-template.component.scss']
})
export class LehrerErfassenComponentTemplateComponent implements OnInit {

  schoolTeacher: Teacher = {firstname: '', shortcut: '', pensum: 0, availableDays: [], schoolModules: []};

  schoolModules: SchoolModules[] = this.schoolModuleService.getSchoolModules();

  schoolDays: string[] = Object.keys(Days).filter((v) => isNaN(Number(v)))

  isDropdownOpen: boolean = false;

  constructor(private schoolModuleService: SchoolModuleService) { }

  ngOnInit(): void {
  }

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }

  update($event: Event) {

  }

  updateCheckboxDay(day: string, checked: boolean) {
    const dayEnum = Days[day as keyof typeof Days];

    if (checked) {
      this.schoolTeacher.availableDays.push(dayEnum);
    } else {
      this.schoolTeacher.availableDays = this.schoolTeacher.availableDays.filter(d => d !== dayEnum);
    }
  }

  updateCheckboxModule(module: SchoolModules, checked: boolean) {
    if (checked) {
      this.schoolTeacher.schoolModules.push(module);
    } else {
      this.schoolTeacher.schoolModules = this.schoolTeacher.schoolModules.filter(m => m !== module);
    }
  }
}
