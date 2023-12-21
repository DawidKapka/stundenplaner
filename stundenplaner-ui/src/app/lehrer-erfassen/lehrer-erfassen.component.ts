import { Component, OnInit } from '@angular/core';
import {Teacher} from "../interfaces/teacher";

@Component({
  selector: 'app-lehrer-erfassen',
  templateUrl: './lehrer-erfassen.component.html',
  styleUrls: ['./lehrer-erfassen.component.scss']
})
export class LehrerErfassenComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  teachers: Teacher[] = [
  ]

  displayedColumns: string[] = ['name', 'shortcut', 'pensum', 'availableDays', 'modules', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;
  }

  editItem(element: Teacher) {

  }

  deleteItem(element: Teacher) {

  }

}
