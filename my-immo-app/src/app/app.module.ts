import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HouseComponent } from './pages/house/house.component';
import { AppartmentComponent } from './pages/appartment/appartment.component';
import { LeaserComponent } from './pages/leaser/leaser.component';
import { P404Component } from './pages/p404/p404.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HouseComponent,
    AppartmentComponent,
    LeaserComponent,
    P404Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
