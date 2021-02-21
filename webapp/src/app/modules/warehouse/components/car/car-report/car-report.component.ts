import {Component, OnInit} from '@angular/core';
import {Car} from "../../../model/car.model";
import {WarehouseService} from "../../../service/warehouse.service";
import {Project} from "../../../model/project.model";

@Component({
  selector: 'app-car-report',
  templateUrl: './car-report.component.html',
  styleUrls: ['./car-report.component.css']
})
export class CarReportComponent implements OnInit {
  cars!: Car[];
  projects!: Project[];
  success: boolean = true;

  constructor(private warehouseService: WarehouseService) {
  }

  ngOnInit(): void {
    this.warehouseService.getResource("/projects").subscribe(r => {
      this.projects = r;
    });
    this.warehouseService.getResource("/cars").subscribe(r => {
      this.cars = r;
    });
  }

  process() {
    this.warehouseService.updateResource("/cars/report", this.cars).subscribe(r => {
      this.success = true;
      this.cars = r;
    }, () => this.success = false);
    this.warehouseService.updateResource("/projects/report", this.projects).subscribe(r => {
      this.success = true;
      this.projects = r;
    }, () => this.success = false);
  }

  setPeople(car: Car, project: Project) {
    if (!project.cars) {
      project.cars = [];
    }
    if (car.id != null) {
      project.cars.push(car.id);
    }
  }
}
