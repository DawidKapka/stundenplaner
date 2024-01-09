import {SchoolModules} from "./schoolModules";
import {Days} from "../enums/days";

export interface Teacher {
    firstname: string;
    shortcut: string;
    pensum: number;
    availableDays: Days[];
    schoolModules: SchoolModules[];
}
