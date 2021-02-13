import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {WarehouseComponent} from "./warehouse.component";
import {WarehouseRoutingModule} from "./warehouse-routing.module";
import {CarComponent} from "./components/car/car.component";
import {PpeComponent} from "./components/ppe/ppe.component";
import {MaterialComponent} from "./components/material/material.component";
import {ProjectComponent} from "./components/project/project.component";
import {NgbModule, NgbNavModule} from "@ng-bootstrap/ng-bootstrap";
import {AddCarInfoComponent} from './components/car/add-car/add-car-info/add-car-info.component';
import {FormsModule} from "@angular/forms";
import {AddCarDocumentsComponent} from './components/car/add-car/add-car-documents/add-car-documents.component';
import {AddCarMaterialsComponent} from './components/car/add-car/add-car-materials/add-car-materials.component';
import {CarListComponent} from './components/car/car-list/car-list.component';
import {PopupComponent} from "./components/popup/popup.component";
import {CarProfileComponent} from './components/car/car-profile/car-profile.component';
import {CarReportComponent} from './components/car/car-report/car-report.component';
import {CarArchiveComponent} from "./components/car/archive/car-archive.component";
import { MaterialAddComponent } from './components/material/material-add/material-add.component';
import { MaterialListComponent } from './components/material/material-list/material-list.component';
import { MaterialArchiveComponent } from './components/material/material-archive/material-archive.component';
import { MaterialProfileComponent } from './components/material/material-profile/material-profile.component';
import { MaterialReportComponent } from './components/material/material-report/material-report.component';
import { PpeAddComponent } from './components/ppe/ppe-add/ppe-add.component';
import { PpeArchiveComponent } from './components/ppe/ppe-archive/ppe-archive.component';
import { PpeListComponent } from './components/ppe/ppe-list/ppe-list.component';
import { PpeProfileComponent } from './components/ppe/ppe-profile/ppe-profile.component';
import { PpeReportComponent } from './components/ppe/ppe-report/ppe-report.component';
import {CompanyComponent} from "./components/company/company.component";
import { ProjectListComponent } from './components/project/project-list/project-list.component';
import { ProjectArchiveComponent } from './components/project/project-archive/project-archive.component';
import { ProjectAddComponent } from './components/project/project-add/project-add.component';
import { CompanyAddComponent } from './components/company/company-add/company-add.component';
import { CompanyListComponent } from './components/company/company-list/company-list.component';
import { CompanyArchiveComponent } from './components/company/company-archive/company-archive.component';
import { CompanyPopupComponent } from './components/company/company-popup/company-popup.component';
import { PpePopupComponent } from './components/ppe/ppe-popup/ppe-popup.component';
import { CarPopupComponent } from './components/car/car-popup/car-popup.component';
import { MaterialPopupComponent } from './components/material/material-popup/material-popup.component';
import { ProjectPopupComponent } from './components/project/project-popup/project-popup.component';

@NgModule({
  declarations: [WarehouseComponent, CarComponent, PpeComponent, MaterialComponent, ProjectComponent, AddCarInfoComponent,
    AddCarDocumentsComponent, AddCarMaterialsComponent, CarListComponent, PopupComponent, CarArchiveComponent, CarProfileComponent,
    CarReportComponent, MaterialAddComponent, MaterialListComponent, MaterialArchiveComponent, MaterialProfileComponent,
    MaterialReportComponent, PpeAddComponent, PpeArchiveComponent, PpeListComponent, PpeProfileComponent, PpeReportComponent, CompanyComponent, ProjectListComponent, ProjectArchiveComponent, ProjectAddComponent, CompanyAddComponent, CompanyListComponent, CompanyArchiveComponent, CompanyPopupComponent, PpePopupComponent, CarPopupComponent, MaterialPopupComponent, ProjectPopupComponent],
  imports: [
    CommonModule,
    WarehouseRoutingModule,
    NgbNavModule,
    FormsModule,
    NgbModule
  ]
})
export class WarehouseModule {
}
