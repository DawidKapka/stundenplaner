import {SchoolModules} from "./schoolModules";
import {Days} from "../enums/days";

export interface Teacher {
    name: string;
    shortcut: string;
    pensum: number;
    availableDays: Days[];
    schoolModules: SchoolModules[];
}
