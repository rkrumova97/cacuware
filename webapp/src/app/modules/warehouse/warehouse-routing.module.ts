import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {WarehouseComponent} from "./warehouse.component";
import {CarComponent} from "./components/car/car.component";
import {MaterialComponent} from "./components/material/material.component";
import {PpeComponent} from "./components/ppe/ppe.component";
import {ProjectComponent} from "./components/project/project.component";
import {CarProfileComponent} from './components/car/car-profile/car-profile.component';
import {CarArchiveComponent} from "./components/car/archive/car-archive.component";
import {MaterialAddComponent} from "./components/material/material-add/material-add.component";
import {MaterialProfileComponent} from "./components/material/material-profile/material-profile.component";
import {MaterialArchiveComponent} from "./components/material/material-archive/material-archive.component";
import {PpeProfileComponent} from "./components/ppe/ppe-profile/ppe-profile.component";
import {PpeArchiveComponent} from "./components/ppe/ppe-archive/ppe-archive.component";
import {CompanyComponent} from "./components/company/company.component";


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
      path: 'cars/profile:id',
      component: CarProfileComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'cars/archive',
      component: CarArchiveComponent,
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
      path: 'materials/profile:id',
      component: MaterialProfileComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'materials/archive',
      component: MaterialArchiveComponent,
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
      path: 'ppe/profile:id',
      component: PpeProfileComponent,
      children: [
        {path: 'warehouse', component: WarehouseComponent}
      ],
    },
    {
      path: 'ppe/archive',
      component: PpeArchiveComponent,
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
    {
      path: 'company',
      component: CompanyComponent,
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
