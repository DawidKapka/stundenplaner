import { Component, OnInit } from '@angular/core';
import {Teacher} from "../interfaces/teacher";
import {MatDialog} from "@angular/material/dialog";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {SchoolModuleService} from "../services/school-module.service";
import {TeacherService} from "../services/teacher.service";

@Component({
  selector: 'app-lehrer-erfassen',
  templateUrl: './lehrer-erfassen.component.html',
  styleUrls: ['./lehrer-erfassen.component.scss']
})
export class LehrerErfassenComponent implements OnInit {

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient,
              private teacherService: TeacherService) { }

  ngOnInit(): void {
  }


  teachers: Teacher[] = [
  ]

  displayedColumns: string[] = ['name', 'shortcut', 'pensum', 'availableDays', 'modules', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;
  }

  editItem(element: Teacher) {

  }

  deleteItem(element: Teacher) {

  }

}
