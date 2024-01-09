import {Component, OnInit, ViewChild} from '@angular/core';
import {Teacher} from "../interfaces/teacher";
import {TeacherService} from "../services/teacher.service";
import {MatDialog} from '@angular/material/dialog';
import {HttpClient} from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';
import {MatTable} from '@angular/material/table';
import {LehrerErfassenComponentTemplateComponent} from '../lehrer-erfassen-component-template/lehrer-erfassen-component-template.component';
import {Days} from "../enums/days";
import {SchoolModules} from "../interfaces/schoolModules";

@Component({
  selector: 'app-lehrer-erfassen',
  templateUrl: './lehrer-erfassen.component.html',
  styleUrls: ['./lehrer-erfassen.component.scss']
})
export class LehrerErfassenComponent implements OnInit {

 // @ts-ignore
  @ViewChild(MatTable) table: MatTable<any>

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient,
              private teacherService: TeacherService) { }

  ngOnInit(): void {
  }


  teachers: Teacher[] = this.teacherService.getTeachers()

  displayedColumns: string[] = ['name', 'shortcut', 'pensum', 'availableDays', 'schoolModules', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('lehrer-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(LehrerErfassenComponentTemplateComponent, {
      width: '600px',
    });

    dialogRef.afterClosed().subscribe((result) => {
       this.addItem(result as Teacher)
       this.updateTable();
    });
  }


  editItem(teacher: Teacher) {
  }

  deleteItem(teacher: Teacher) {
    this.teacherService.deleteTeacher(teacher)
    this.updateTable();
  }

  addItem(teacher: Teacher) {
    this.teacherService.addTeacher(teacher)
    this.updateTable()
  }

  updateTable() {
    this.table.renderRows()
  }

  getDaysText(days: Days[]): string[] {
    return days.map(day => this.getDayText(day));
  }


  getDayText(day: Days): string {
    switch (day) {
      case Days.MONDAY_MORNING: return 'Mo VM';
      case Days.MONDAY_AFTERNOON: return 'Mo NM';
      case Days.TUESDAY_MORNING: return 'Di VM';
      case Days.TUESDAY_AFTERNOON: return 'Di NM';
      case Days.WEDNESDAY_MORNING: return 'Mi VM';
      case Days.WEDNESDAY_AFTERNOON: return 'Mi NM';
      case Days.THURSDAY_MORNING: return 'Do VM';
      case Days.THURSDAY_AFTERNOON: return 'Do NM';
      case Days.FRIDAY_MORNING: return 'Fr VM';
      case Days.FRIDAY_AFTERNOON: return 'Fr NM';
      default: return '';
    }
  }

  getSchoolModules(schoolModules: SchoolModules[]) {
    return schoolModules.map(module => module.shortcut).join(', ');
  }
}
