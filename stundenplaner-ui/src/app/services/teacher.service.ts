import {Injectable} from '@angular/core';
import {Teacher} from "../interfaces/teacher";

@Injectable({
    providedIn: 'root'
})
export class TeacherService {

    teachers: Teacher[] = [];

    constructor() {
    }

    getTeacher(): Teacher[] {
        return this.teachers;
    }

    addTeacher(teacher: Teacher) {
        this.teachers.push(teacher);
    }

    deleteTeacher(teacher: Teacher) {

    }
}
