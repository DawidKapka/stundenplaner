import {Component, OnInit, ViewChild} from '@angular/core';
import {Room} from "../interfaces/Room";
import {MatDialog} from "@angular/material/dialog";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {RoomService} from "../services/room.service";
import {ZimmerErfassenComponentTemplateComponent} from '../zimmer-erfassen-component-template/zimmer-erfassen-component-template.component';
import {MatTable} from '@angular/material/table';

@Component({
  selector: 'app-zimmer-erfassen',
  templateUrl: './zimmer-erfassen.component.html',
  styleUrls: ['./zimmer-erfassen.component.scss']
})
export class ZimmerErfassenComponent implements OnInit {

  // @ts-ignore
  @ViewChild(MatTable) table: MatTable<any>

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient,
              private roomService: RoomService) { }

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

  editItem(element: Room) {
  }

  deleteItem(room: Room) {
    this.roomService.deleteRoom(room)
    console.log(this.roomService.rooms);
    this.updateTable();
  }

  addItem(room: Room) {
    this.roomService.addRoom(room)

  }

  updateTable() {
    this.table.renderRows()
  }
}
