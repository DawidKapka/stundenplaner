import { Component, OnInit } from '@angular/core';
import {Room} from "../interfaces/Room";
import {Roomtype} from "../enums/roomtype";
import {Days} from "../enums/days";

@Component({
  selector: 'app-zimmer-erfassen-component-template',
  templateUrl: './zimmer-erfassen-component-template.component.html',
  styleUrls: ['./zimmer-erfassen-component-template.component.scss']
})
export class ZimmerErfassenComponentTemplateComponent implements OnInit {

  room: Room = {name: '', roomType: 1};

  roomType: string[] = Object.keys(Roomtype).filter((v) => isNaN(Number(v)))

  constructor() { }

  ngOnInit(): void {
  }


  updateCheckboxRoomtype(roomType: string, checked: boolean) {
    const roomEnum: Roomtype = Roomtype[roomType as keyof typeof Roomtype];

    if (checked) {
      this.room.roomType = roomEnum
    }
  }
}
