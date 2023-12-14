import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {FaecherErfassenComponent} from "./faecher-erfassen/faecher-erfassen.component";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatStepperModule} from "@angular/material/stepper";
import {MatIconModule} from "@angular/material/icon";
import { LehrerErfassenComponent } from './lehrer-erfassen/lehrer-erfassen.component';
import { ZimmerErfassenComponent } from './zimmer-erfassen/zimmer-erfassen.component';
import { KlasseErfassenComponent } from './klasse-erfassen/klasse-erfassen.component';
import {MatCardModule} from '@angular/material/card';
import {FaecherErfassenComponent} from './faecher-erfassen/faecher-erfassen.component';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    FaecherErfassenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent],
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        FaecherErfassenComponent,
        LehrerErfassenComponent,
        ZimmerErfassenComponent,
        KlasseErfassenComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatTableModule,
        MatButtonModule,
        MatStepperModule,
        MatIconModule
    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule { }
