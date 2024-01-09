import {Days} from "../enums/days";

export interface SchoolClass {
    name: string;
    daysAvailable: Days[];
    modules: string[];
    hasBasislehrjahr: boolean;
}
