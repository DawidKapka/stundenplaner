import { Component, OnInit } from '@angular/core';
import {SchoolModules} from "../interfaces/schoolModules";

@Component({
  selector: 'app-faecher-erfassen',
  templateUrl: './faecher-erfassen.component.html',
  styleUrls: ['./faecher-erfassen.component.scss']
})
export class FaecherErfassenComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  schoolModules: SchoolModules[] = [
    {shortcut: 'm123', name: "Super duper jaa"},
    {shortcut: 'm123', name: "Super duper jaa"},
    {shortcut: 'm123', name: "Super duper jaa"},
    {shortcut: 'm123', name: "Super duper jaa"},
  ]

  displayedColumns: string[] = ['shortcut', 'name'];

  openPopup() {

  }
}
