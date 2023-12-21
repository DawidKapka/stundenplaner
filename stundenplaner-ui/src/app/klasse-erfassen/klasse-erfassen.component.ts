import { Component, OnInit } from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";
import {SchoolClass} from "../interfaces/schoolClass";

@Component({
  selector: 'app-klasse-erfassen',
  templateUrl: './klasse-erfassen.component.html',
  styleUrls: ['./klasse-erfassen.component.scss']
})
export class KlasseErfassenComponent implements OnInit {

  constructor() { }

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
