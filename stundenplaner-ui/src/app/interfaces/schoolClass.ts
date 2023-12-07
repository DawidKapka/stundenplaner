import {Days} from "../enums/days";
import {SchoolModules} from "./schoolModules";

export interface SchoolClass {
    name: string;
    daysUnavailable: Days[];
    modules: SchoolModules[];
}
