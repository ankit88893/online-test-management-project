import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddtestComponent } from './addtest/addtest.component';
import { TestlistComponent } from './testlist/testlist.component';
import { TestdetailsComponent } from './testdetails/testdetails.component';
import { HomeComponent } from './home/home.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TestService } from './service/testservice';
import { FormGroup, FormControl } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AddtestComponent,
    TestlistComponent,
    TestdetailsComponent,
    HomeComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [TestService,HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
