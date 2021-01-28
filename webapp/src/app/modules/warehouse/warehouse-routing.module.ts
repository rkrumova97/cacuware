import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {WarehouseComponent} from "./warehouse.component";
import {CarComponent} from "./components/car/car.component";
import {MaterialComponent} from "./components/material/material.component";
import {PpeComponent} from "./components/ppe/ppe.component";
import {ProjectComponent} from "./components/project/project.component";
import {AddCarInfoComponent} from "./components/car/add-car/add-car-info/add-car-info.component";
import {AddCarDocumentsComponent} from "./components/car/add-car/add-car-documents/add-car-documents.component";
import { CarProfileComponent } from './components/car/car-profile/car-profile.component';


export class WareRoutes {
  static wareRoutes: Routes = [
    {
      path: '',
      component: WarehouseComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'cars',
      component: CarComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'cars/documents',
      component: AddCarDocumentsComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
{
      path: 'cars/profile',
  component: CarProfileComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'materials',
      component: MaterialComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'ppe',
      component: PpeComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'projects',
      component: ProjectComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
  ];
}

@NgModule({
  imports: [RouterModule.forChild(WareRoutes.wareRoutes)],
  exports: [RouterModule]
})
export class WarehouseRoutingModule {
}
