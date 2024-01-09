import {Injectable} from '@angular/core';
import {Teacher} from "../interfaces/teacher";

@Injectable({
    providedIn: 'root'
})
export class TeacherService {

    teachers: Teacher[] = [];

    constructor() {
    }

    getTeachers(): Teacher[] {
        return this.teachers;
    }

    addTeacher(teacher: Teacher) {
        this.teachers.push(teacher);
    }

    deleteTeacher(teacher: Teacher) {

    }
}
