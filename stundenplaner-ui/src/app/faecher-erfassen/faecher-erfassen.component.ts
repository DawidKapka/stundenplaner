import {Component, OnInit, ViewChild} from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";
import {MatDialog} from '@angular/material/dialog';
import { DomSanitizer } from '@angular/platform-browser';
import {HttpClient} from '@angular/common/http';
import {FaecherErfassenComponentTemplateComponent} from '../faecher-erfassen-component-template/faecher-erfassen-component-template.component';
import {SchoolModuleService} from "../services/school-module.service";
import {MatTable} from "@angular/material/table";


@Component({
  selector: 'app-faecher-erfassen',
  templateUrl: './faecher-erfassen.component.html',
  styleUrls: ['./faecher-erfassen.component.scss']
})
export class FaecherErfassenComponent implements OnInit {

  // @ts-ignore
  @ViewChild(MatTable) table: MatTable<any>

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient,
              private moduleService: SchoolModuleService) { }

  ngOnInit(): void {
  }

  schoolModules: SchoolModules[] = this.moduleService.getSchoolModules();

  displayedColumns: string[] = ['shortcut', 'name', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('faecher-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(FaecherErfassenComponentTemplateComponent, {
      width: '600px',
    });


    dialogRef.afterClosed().subscribe((result) => {
      this.addItem(result)
      this.updateTable();
    });
  }

  editItem(element: SchoolModules) {
  }

  deleteItem(element: SchoolModules) {
  }

  addItem(module: SchoolModules) {
    this.moduleService.addSchoolModule(module)

  }

  updateTable() {
    this.table.renderRows()
  }
}
