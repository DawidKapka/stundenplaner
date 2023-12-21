import {Injectable} from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";

@Injectable({
    providedIn: 'root'
})
export class SchoolModuleService {

    schoolModules: SchoolModules[] = [];

    constructor() {
    }

    getSchoolModules(): SchoolModules[] {
        return this.schoolModules;
    }

    addSchoolModule(module: SchoolModules) {
        this.schoolModules.push(module)
    }

    deleteModule(module: SchoolModules) {
    }
}
