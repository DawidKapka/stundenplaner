import {Component, OnInit, ViewChild} from '@angular/core';
import {Teacher} from "../interfaces/teacher";
import {FaecherErfassenComponentTemplateComponent} from '../faecher-erfassen-component-template/faecher-erfassen-component-template.component';
import {MatDialog} from '@angular/material/dialog';
import {HttpClient} from '@angular/common/http';
import {SchoolModules} from '../interfaces/schoolModules';
import {DomSanitizer} from '@angular/platform-browser';
import {SchoolModuleService} from '../services/school-module.service';
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
              private moduleService: SchoolModuleService) { }

  ngOnInit(): void {
  }


  teachers: Teacher[] = [
  ]

  displayedColumns: string[] = ['name', 'shortcut', 'pensum', 'availableDays', 'modules', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('faecher-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(LehrerErfassenComponentTemplateComponent, {
      width: '600px',
    });

    dialogRef.afterClosed().subscribe((result) => {
       this.addItem(result)
       this.updateTable();
    });
  }

  // change school to teacher

  editItem(element: Teacher) {
  }

  deleteItem(module: Teacher) {
    this.moduleService.deleteModule(module)
    console.log(this.moduleService.schoolModules);
    this.updateTable();
  }

  addItem(module: Teacher) {
    this.moduleService.addSchoolModule(module)

  }

  updateTable() {
    this.table.renderRows()
  }
}
