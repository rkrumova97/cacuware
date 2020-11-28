import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {WarehouseComponent} from "./warehouse.component";
import {WarehouseRoutingModule} from "./warehouse-routing.module";
import {CarComponent} from "./components/car/car.component";
import {PpeComponent} from "./components/ppe/ppe.component";
import {MaterialComponent} from "./components/material/material.component";
import {ProjectComponent} from "./components/project/project.component";
import {NgbNavModule} from "@ng-bootstrap/ng-bootstrap";
import { AddCarInfoComponent } from './components/car/add-car/add-car-info/add-car-info.component';
import {FormsModule} from "@angular/forms";
import { AddCarDocumentsComponent } from './components/car/add-car/add-car-documents/add-car-documents.component';
import { AddCarMaterialsComponent } from './components/car/add-car/add-car-materials/add-car-materials.component';
import { CarListComponent } from './components/car/car-list/car-list.component';
import {PopupComponent} from "./components/popup/popup.component";
import { ArchiveComponent } from './components/archive/archive.component';

@NgModule({
  declarations: [WarehouseComponent, CarComponent, PpeComponent, MaterialComponent, ProjectComponent, AddCarInfoComponent, AddCarDocumentsComponent, AddCarMaterialsComponent, CarListComponent, PopupComponent, ArchiveComponent],
  imports: [
    CommonModule,
    WarehouseRoutingModule,
    NgbNavModule,
    FormsModule
  ]
})
export class WarehouseModule { }
