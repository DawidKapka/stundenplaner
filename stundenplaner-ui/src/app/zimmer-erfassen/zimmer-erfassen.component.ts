import { Component, OnInit } from '@angular/core';
import {SchoolClass} from "../interfaces/schoolClass";
import {Room} from "../interfaces/Room";
import {LehrerErfassenComponentTemplateComponent} from '../lehrer-erfassen-component-template/lehrer-erfassen-component-template.component';
import {MatDialog} from '@angular/material/dialog';
import {DomSanitizer} from '@angular/platform-browser';
import {HttpClient} from '@angular/common/http';
import {ZimmerErfassenComponentTemplateComponent} from '../zimmer-erfassen-component-template/zimmer-erfassen-component-template.component';
import {Teacher} from '../interfaces/teacher';

@Component({
  selector: 'app-zimmer-erfassen',
  templateUrl: './zimmer-erfassen.component.html',
  styleUrls: ['./zimmer-erfassen.component.scss']
})
export class ZimmerErfassenComponent implements OnInit {

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient) { }

  ngOnInit(): void {
  }

  rooms: Room[] = [
  ]

  displayedColumns: string[] = ['name', 'roomType', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;
    const dialogRef = this.dialog.open(ZimmerErfassenComponentTemplateComponent, {
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
