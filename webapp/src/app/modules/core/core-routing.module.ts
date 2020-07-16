import {RouterModule, Routes} from "@angular/router";
import {CoreComponent} from "./core/core.component";
import {NavigationComponent} from "./navigation/navigation.component";
import {ErrorComponent} from "./error/error.component";
import {NgModule} from "@angular/core";

export class CoreRoutes {
  static coreRoutes: Routes = [
    {
      path: '',
      component: CoreComponent,
      children: [
        {path: 'core', component: CoreComponent},
      ]
    } ,
    {
      path: 'nav',
      component: NavigationComponent,
      children: [
        {path: 'nav', component: NavigationComponent},
      ]
    },
    {
      path: '**',
      component: ErrorComponent,
      children: [
        {path: '**', component: ErrorComponent},
      ]
    }
  ];
}

@NgModule({
  imports: [RouterModule.forChild(CoreRoutes.coreRoutes)],
  exports: [RouterModule]
})
export class CoreRoutingModule { }
