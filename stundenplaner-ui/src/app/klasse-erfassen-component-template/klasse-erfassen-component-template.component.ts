import { Component, OnInit } from '@angular/core';

import {Days} from "../enums/days";
import {SchoolClass} from "../interfaces/schoolClass";
import {SchoolModules} from "../interfaces/schoolModules";
import {SchoolModuleService} from "../services/school-module.service";


@Component({
  selector: 'app-zimmer-erfassen-component-template',
  templateUrl: './klasse-erfassen-component-template.component.html',
  styleUrls: ['./klasse-erfassen-component-template.component.scss']
})
export class KlasseErfassenComponentTemplateComponent implements OnInit {

  schoolClass: SchoolClass = {name: '', daysAvailable: [], modules: [], hasBasislehrjahr: false};

  schoolDays: string[] = Object.keys(Days).filter((v) => isNaN(Number(v)))

  schoolModules: SchoolModules[] = this.schoolModuleService.getSchoolModules();

  constructor(private schoolModuleService: SchoolModuleService) { }

  ngOnInit(): void {
  }

  updateCheckboxDay(day: string, checked: boolean) {
    const dayEnum = Days[day as keyof typeof Days];

    if (checked) {
      this.schoolClass.daysAvailable.push(dayEnum);
    } else {
      this.schoolClass.daysAvailable = this.schoolClass.daysAvailable.filter(d => d !== dayEnum);
    }
  }

  updateCheckboxModule(module: SchoolModules, checked: boolean) {
    if (checked) {
      this.schoolClass.modules.push(module.shortcut);
    } else {
      this.schoolClass.modules = this.schoolClass.modules.filter(m => m !== module.shortcut);
    }
  }

}
