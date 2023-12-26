import {Days} from "../enums/days";
import {SchoolModules} from "./schoolModules";

export interface SchoolClass {
    name: string;
    daysAvailable: Days[];
    modules: SchoolModules[];
    hasBasislehrjahr: boolean;
}
