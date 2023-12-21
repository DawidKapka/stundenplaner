import { Component, OnInit } from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";
import {SchoolClass} from "../interfaces/schoolClass";
import {MatDialog} from "@angular/material/dialog";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {TeacherService} from "../services/teacher.service";
import {SchoolClassService} from "../services/school-class.service";

@Component({
  selector: 'app-klasse-erfassen',
  templateUrl: './klasse-erfassen.component.html',
  styleUrls: ['./klasse-erfassen.component.scss']
})
export class KlasseErfassenComponent implements OnInit {

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient,
              private schoolClassService: SchoolClassService) { }

  ngOnInit(): void {
  }

  schoolClasses: SchoolClass[] = [
  ]

  displayedColumns: string[] = ['name', 'daysAvailable', 'modules', 'hasBasislehrjahr', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;
  }

  editItem(element: SchoolClass) {

  }

  deleteItem(element: SchoolClass) {

  }
}
