import {Component, OnInit, ViewChild} from '@angular/core';
import {SchoolClass} from "../interfaces/schoolClass";
import {Room} from "../interfaces/Room";
import {MatDialog} from "@angular/material/dialog";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {TeacherService} from "../services/teacher.service";
import {RoomService} from "../services/room.service";
import {
  ZimmerErfassenComponentTemplateComponent
} from "../zimmer-erfassen-component-template/zimmer-erfassen-component-template.component";
import {MatTable} from "@angular/material/table";
import {Roomtype} from "../enums/roomtype";

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

  rooms: Room[] = this.roomService.getRooms()

  displayedColumns: string[] = ['name', 'roomType', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('zimmer-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(ZimmerErfassenComponentTemplateComponent, {
      width: '600px',
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.addItem(result as Room)
      this.updateTable();
    });  }

  editItem(room: Room) {

  }

  deleteItem(room: Room) {

  }

  addItem(room: Room) {
    this.roomService.addRoom(room);
    this.updateTable()
  }

  updateTable() {
    this.table.renderRows()
  }

  getRoomTypeText(roomType: Roomtype): string {
    switch (roomType) {
      case Roomtype.LABORZIMMER:
        return 'Laborzimmer';
      case Roomtype.SCHULZIMMER:
        return 'Schulzimmer';
      case Roomtype.SPORTHALLE:
        return 'Sporthalle';
      default:
        return '';
    }
  }


}
