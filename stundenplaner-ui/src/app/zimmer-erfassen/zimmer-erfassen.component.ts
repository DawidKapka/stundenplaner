import { Component, OnInit } from '@angular/core';
import {SchoolClass} from "../interfaces/schoolClass";
import {Room} from "../interfaces/Room";

@Component({
  selector: 'app-zimmer-erfassen',
  templateUrl: './zimmer-erfassen.component.html',
  styleUrls: ['./zimmer-erfassen.component.scss']
})
export class ZimmerErfassenComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  rooms: Room[] = [
  ]

  displayedColumns: string[] = ['name', 'roomType', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;
  }

  editItem(element: Room) {

  }

  deleteItem(element: Room) {

  }

}
