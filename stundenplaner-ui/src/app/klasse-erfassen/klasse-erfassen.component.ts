import { Component, OnInit } from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";
import {SchoolClass} from "../interfaces/schoolClass";
import {ZimmerErfassenComponentTemplateComponent} from '../zimmer-erfassen-component-template/zimmer-erfassen-component-template.component';
import {Teacher} from '../interfaces/teacher';
import {MatDialog} from '@angular/material/dialog';
import {DomSanitizer} from '@angular/platform-browser';
import {HttpClient} from '@angular/common/http';
import {KlasseErfassenComponentTemplateComponent} from '../klasse-erfassen-component-template/klasse-erfassen-component-template.component';

@Component({
  selector: 'app-klasse-erfassen',
  templateUrl: './klasse-erfassen.component.html',
  styleUrls: ['./klasse-erfassen.component.scss']
})
export class KlasseErfassenComponent implements OnInit {

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient) { }

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

  //noch machen

  editItem(element: Teacher) {
  }

  deleteItem(module: Teacher) {
  }

  addItem(module: Teacher) {
  }

  updateTable() {
  }

}
