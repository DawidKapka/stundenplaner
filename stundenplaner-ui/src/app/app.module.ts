import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTableModule} from "@angular/material/table";
import {MatStepperModule} from "@angular/material/stepper";
import {MatIconModule} from "@angular/material/icon";
import {LehrerErfassenComponent} from './lehrer-erfassen/lehrer-erfassen.component';
import {ZimmerErfassenComponent} from './zimmer-erfassen/zimmer-erfassen.component';
import {KlasseErfassenComponent} from './klasse-erfassen/klasse-erfassen.component';
import {MatCardModule} from '@angular/material/card';
import {FaecherErfassenComponent} from './faecher-erfassen/faecher-erfassen.component';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {HttpClientModule} from '@angular/common/http';
import { FaecherErfassenComponentTemplateComponent } from './faecher-erfassen-component-template/faecher-erfassen-component-template.component';
import {FormsModule} from '@angular/forms';


@NgModule({
    providers: [],
    bootstrap: [AppComponent],
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        FaecherErfassenComponent,
        LehrerErfassenComponent,
        ZimmerErfassenComponent,
        KlasseErfassenComponent,
        FaecherErfassenComponentTemplateComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        HttpClientModule,
        MatToolbarModule,
        MatTableModule,
        MatButtonModule,
        MatStepperModule,
        MatIconModule,
        MatCardModule,
        MatInputModule,
        MatDialogModule,
        FormsModule
    ]
})
export class AppModule {
}
