import { Component, OnInit } from '@angular/core';
import {Roomtype} from '../enums/roomtype';
import {Room} from '../interfaces/Room';

@Component({
  selector: 'app-zimmer-erfassen-component-template',
  templateUrl: './zimmer-erfassen-component-template.component.html',
  styleUrls: ['./zimmer-erfassen-component-template.component.scss']
})
export class ZimmerErfassenComponentTemplateComponent implements OnInit {

  schoolRoom: Room = {name: '', roomType: Roomtype.SCHULZIMMER};

  constructor() { }

  ngOnInit(): void {
  }

}
