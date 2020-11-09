import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {WarehouseComponent} from "./warehouse.component";

export class WareRoutes {
  static wareRoutes: Routes = [
    {
      path: '',
      component: WarehouseComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    }
  ];
}

@NgModule({
  imports: [RouterModule.forChild(WareRoutes.wareRoutes)],
  exports: [RouterModule]
})
export class WarehouseRoutingModule {
}
