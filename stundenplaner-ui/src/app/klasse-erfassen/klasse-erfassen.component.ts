import {Component, OnInit, ViewChild} from '@angular/core';
import {SchoolClass} from "../interfaces/schoolClass";
import {MatDialog} from "@angular/material/dialog";
import {DomSanitizer} from "@angular/platform-browser";
import {HttpClient} from "@angular/common/http";
import {SchoolClassService} from "../services/school-class.service";
import {
  KlasseErfassenComponentTemplateComponent
} from "../klasse-erfassen-component-template/klasse-erfassen-component-template.component";
import {MatTable} from "@angular/material/table";
import {Days} from "../enums/days";
import {SchoolModules} from "../interfaces/schoolModules";

@Component({
  selector: 'app-klasse-erfassen',
  templateUrl: './klasse-erfassen.component.html',
  styleUrls: ['./klasse-erfassen.component.scss']
})
export class KlasseErfassenComponent implements OnInit {

  // @ts-ignore
  @ViewChild(MatTable) table: MatTable<any>

  constructor(public dialog: MatDialog,
              private sanitizer: DomSanitizer,
              private http: HttpClient,
              private schoolClassService: SchoolClassService) { }

  ngOnInit(): void {
  }

  schoolClasses: SchoolClass[] = this.schoolClassService.getSchoolClasses();

  displayedColumns: string[] = ['name', 'daysAvailable', 'modules', 'hasBasislehrjahr', 'action'];

  showPopup: boolean = false;

  openPopup() {
    this.http.get('klasse-erfassen-template.component.html', { responseType: 'text' })

    this.showPopup = true;
    const dialogRef = this.dialog.open(KlasseErfassenComponentTemplateComponent, {
      width: '600px',
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.addItem(result as SchoolClass)
      console.log(result)
      this.updateTable();
    });  }

  private addItem(schoolClass: SchoolClass) {
    this.schoolClassService.addSchoolClass(schoolClass);
    this.updateTable();
  }


  editItem(schoolClass: SchoolClass) {

  }

  deleteItem(schoolClass: SchoolClass) {

  }

  updateTable() {
    this.table.renderRows()
  }

  getDaysText(days: Days[]): string[] {
    return days.map(day => this.getDayText(day));
  }


  getDayText(day: Days): string {
    switch (day) {
      case Days.MONDAY_MORNING: return 'Mo VM';
      case Days.MONDAY_AFTERNOON: return 'Mo NM';
      case Days.TUESDAY_MORNING: return 'Di VM';
      case Days.TUESDAY_AFTERNOON: return 'Di NM';
      case Days.WEDNESDAY_MORNING: return 'Mi VM';
      case Days.WEDNESDAY_AFTERNOON: return 'Mi NM';
      case Days.THURSDAY_MORNING: return 'Do VM';
      case Days.THURSDAY_AFTERNOON: return 'Do NM';
      case Days.FRIDAY_MORNING: return 'Fr VM';
      case Days.FRIDAY_AFTERNOON: return 'Fr NM';
      default: return '';
    }
  }

  getSchoolModules(schoolModules: SchoolModules[]) {
    return schoolModules.map(module => module.shortcut).join(', ');
  }

}
