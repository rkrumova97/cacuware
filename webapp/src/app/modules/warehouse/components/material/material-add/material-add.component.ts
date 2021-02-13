import { Component, OnInit } from '@angular/core';
import {Material} from "../../../model/material.model";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../../service/warehouse.service";
import {Company} from "../../../model/company.model";

@Component({
  selector: 'app-material-add',
  templateUrl: './material-add.component.html',
  styleUrls: ['./material-add.component.css']
})
export class MaterialAddComponent implements OnInit {
  material!: Material;
  submitted!: Boolean;
  success: boolean = true;

  constructor(private http: HttpClient, private router: Router,
              private warehouseService: WarehouseService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.material = new Material();
    if (this.route.snapshot.paramMap.get('id') !== undefined && this.route.snapshot.paramMap.get('id') !== null) {
      this.warehouseService.getOneResource("/api/warehouse/materials" + this.route.snapshot.paramMap.get('id')).subscribe(res => {
        this.material = res;
      });
    }
    console.log(this.route.snapshot.paramMap.get('id'));
  }

  close() {
    this.success = true;
  }

  process() {
    this.warehouseService.postResource("/materials", this.material).subscribe(r => {
      this.success = true;
      this.material = r;
      this.router.navigate(['/warehouse/materials/profile/'+this.material.id])
    }, () => this.success = false);
  }

}
