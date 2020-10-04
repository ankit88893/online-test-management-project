import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddtestComponent } from './addtest/addtest.component'

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TestdetailsComponent } from './testdetails/testdetails.component';
import { TestlistComponent } from './testlist/testlist.component';


const routes: Routes = [
  {
    path: "app-home",
    component: HomeComponent
  },
  {
    path: '',
    redirectTo: 'app-home',
    pathMatch: 'full'
  },

  {
    path: 'testdetails/:id',
    component: TestdetailsComponent
  },
  {
    path: 'testdetails',
    component: TestdetailsComponent
  },

  {
    path: 'addtest',
    component: AddtestComponent
  },
  

  {
    path: 'testlist',
    component: TestlistComponent
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
