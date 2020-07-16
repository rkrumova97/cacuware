import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SecurityComponent} from './security.component';

export class SecurityRoutes {
  static securityRoutes: Routes = [
    {
      path: '',
      component: SecurityComponent,
      children: [
        {path: 'login', component: SecurityComponent}
      ],
    }
  ];
}

@NgModule({
  imports: [RouterModule.forChild(SecurityRoutes.securityRoutes)],
  exports: [RouterModule]
})
export class SecurityRoutingModule { }
