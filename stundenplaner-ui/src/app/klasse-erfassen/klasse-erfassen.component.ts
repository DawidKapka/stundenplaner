import {Component, OnInit, ViewChild} from '@angular/core';
import {SchoolClass} from "../interfaces/schoolClass";
import {MatDialog} from '@angular/material/dialog';
import {DomSanitizer} from '@angular/platform-browser';
import {HttpClient} from '@angular/common/http';
import {KlasseErfassenComponentTemplateComponent} from '../klasse-erfassen-component-template/klasse-erfassen-component-template.component';
import {SchoolClassService} from '../services/school-class.service';
import {MatTable} from '@angular/material/table';

@Component({
  selector: 'app-klasse-erfassen',
  templateUrl: './klasse-erfassen.component.html',
  styleUrls: ['./klasse-erfassen.component.scss']
})
export class KlasseErfassenComponent implements OnInit {

  // @ts-ignore
  @ViewChild(MatTable) table: MatTable<any>

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
    const dialogRef = this.dialog.open(KlasseErfassenComponentTemplateComponent, {
      width: '600px',
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.addItem(result)
      this.updateTable();
    });
  }

  editItem(element: SchoolClass) {
  }

  deleteItem(schoolClass: SchoolClass) {
    this.schoolClassService.deleteSchoolClass(schoolClass)
    console.log(this.schoolClassService.schoolClasses);
    this.updateTable();
  }

  addItem(schoolClass: SchoolClass) {
    this.schoolClassService.addSchoolClass(schoolClass)

  }

  updateTable() {
    this.table.renderRows()
  }
}
