import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'stundenplaner-ui';
  erfassenDone = false
    generateSchedule() {

    }

    showOverview() {
        this.erfassenDone = true;
    }
}
