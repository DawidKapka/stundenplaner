import {Component, OnInit} from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";
import {MatDialog} from '@angular/material/dialog';
import { DomSanitizer } from '@angular/platform-browser';
import {HttpClient} from '@angular/common/http';
import {FaecherErfassenComponentTemplateComponent} from '../faecher-erfassen-component-template/faecher-erfassen-component-template.component';


@Component({
  selector: 'app-faecher-erfassen',
  templateUrl: './faecher-erfassen.component.html',
  styleUrls: ['./faecher-erfassen.component.scss']
})
export class FaecherErfassenComponent implements OnInit {

  constructor(public dialog: MatDialog, private sanitizer: DomSanitizer, private http: HttpClient) { }

  ngOnInit(): void {
  }

  schoolModules: SchoolModules[] = [
    {shortcut: 'm123', name: "Super duper jaa"},
    {shortcut: 'm123', name: "Super duper jaa"},
    {shortcut: 'm123', name: "Super duper jaa"},
    {shortcut: 'm123', name: "Super duper jaa"},
  ]

  displayedColumns: string[] = ['shortcut', 'name', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('faecher-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(FaecherErfassenComponentTemplateComponent, {
      width: '600px',
    });


    dialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed', result);
    });
  }

  editItem(element: SchoolModules) {
    this.http.get('faecher-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(FaecherErfassenComponentTemplateComponent, {
      width: '400px',
      data: element
    });


    dialogRef.afterClosed().subscribe((result) => {
      console.log('The dialog was closed', result);
    });
  }

  deleteItem(element: SchoolModules) {

  }
}
