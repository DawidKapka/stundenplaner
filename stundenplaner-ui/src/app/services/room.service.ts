import { Injectable } from '@angular/core';
import {Room} from "../interfaces/Room";

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  rooms: Room[] = [];

  constructor() { }

  getRooms(): Room[] {
    return this.rooms;
  }

  addRoom(room: Room) {
    this.rooms.push(room)
  }

  deleteRoom(room: Room) {

  }
}
