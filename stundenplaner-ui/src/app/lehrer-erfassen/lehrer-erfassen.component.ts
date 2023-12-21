import {Component, OnInit, ViewChild} from '@angular/core';
import {Teacher} from "../interfaces/teacher";
import {TeacherService} from "../services/teacher.service";
import {MatDialog} from '@angular/material/dialog';
import {HttpClient} from '@angular/common/http';
import {DomSanitizer} from '@angular/platform-browser';
import {MatTable} from '@angular/material/table';
import {LehrerErfassenComponentTemplateComponent} from '../lehrer-erfassen-component-template/lehrer-erfassen-component-template.component';

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


  teachers: Teacher[] = [
  ]

  displayedColumns: string[] = ['name', 'shortcut', 'pensum', 'availableDays', 'modules', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('lehrer-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(LehrerErfassenComponentTemplateComponent, {
      width: '600px',
    });

    dialogRef.afterClosed().subscribe((result) => {
       this.addItem(result)
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

  }

  updateTable() {
    this.table.renderRows()
  }
}
