import { Injectable } from '@angular/core';
import {SchoolClass} from "../interfaces/schoolClass";

@Injectable({
  providedIn: 'root'
})
export class SchoolClassService {

  schoolClasses: SchoolClass[] = [];

  constructor() { }

  getSchoolClasses(): SchoolClass[] {
    return this.schoolClasses;
  }

  addSchoolClass(schoolClass: SchoolClass) {
    this.schoolClasses.push(schoolClass)
  }

  deleteSchoolClass(schoolClass: SchoolClass) {

  }
}
