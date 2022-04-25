import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HouseComponent } from './pages/house/house.component';
import { AppartmentComponent } from './pages/appartment/appartment.component';
import { LeaserComponent } from './pages/leaser/leaser.component';
import { P404Component } from './pages/p404/p404.component';

const routes: Routes = [
  {path:'', redirectTo: '/house', pathMatch: 'full'},
  {path:'house', component: HouseComponent},
  {path:'appartment', component: AppartmentComponent},
  {path:'leaser', component: LeaserComponent},
  {path:'404', component: P404Component},
  {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
