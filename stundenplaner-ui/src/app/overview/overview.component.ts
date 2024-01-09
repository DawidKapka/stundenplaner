import { Component, OnInit } from '@angular/core';
import {SchoolModuleService} from "../services/school-module.service";
import {RoomService} from "../services/room.service";
import {SchoolClassService} from "../services/school-class.service";
import {TeacherService} from "../services/teacher.service";
import {SchoolModules} from "../interfaces/schoolModules";
import {Room} from "../interfaces/Room";
import {SchoolClass} from "../interfaces/schoolClass";
import {Teacher} from "../interfaces/teacher";
import axios from "axios";

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.scss']
})
export class OverviewComponent implements OnInit {

  schoolModules: SchoolModules[] = this.schoolModuleService.getSchoolModules();
  rooms: Room[] = this.roomService.getRooms();
  schoolClasses: SchoolClass[] = this.schoolClassService.getSchoolClasses();
  teachers: Teacher[] = this.teacherService.getTeachers();

  constructor(
      private schoolModuleService: SchoolModuleService,
      private roomService: RoomService,
      private schoolClassService: SchoolClassService,
      private teacherService: TeacherService
  ) { }



  ngOnInit(): void {
    axios.post('http://localhost:9080/api/v1/module', {modules: this.schoolModules}).then(() => {
      axios.post('http://localhost:9080/api/v1/class', {classes: this.schoolClasses})
      axios.post('http://localhost:9080/api/v1/teacher', {teachers: this.teachers})
      axios.post('http://localhost:9080/api/v1/room', {teachers: this.rooms})
    }
  )
  }


}
