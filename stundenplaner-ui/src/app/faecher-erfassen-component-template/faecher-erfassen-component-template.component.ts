import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-faecher-erfassen-component-template',
  templateUrl: './faecher-erfassen-component-template.component.html',
  styleUrls: ['./faecher-erfassen-component-template.component.scss']
})
export class FaecherErfassenComponentTemplateComponent implements OnInit {

  shortName: string = '';
  longName: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  addSubject() {
    console.log('ShortName Value:', this.shortName);
    console.log('LongName Value:', this.longName);

  }
}
