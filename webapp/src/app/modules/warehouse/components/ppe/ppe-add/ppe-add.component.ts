import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../../service/warehouse.service";
import {Ppe} from "../../../model/ppe.model";
import {Material} from "../../../model/material.model";

@Component({
  selector: 'app-ppe-add',
  templateUrl: './ppe-add.component.html',
  styleUrls: ['./ppe-add.component.css']
})
export class PpeAddComponent implements OnInit {
  ppe!: Ppe;
  submitted!: Boolean;
  success: boolean = true;
  material!: Material;

  constructor(private http: HttpClient, private router: Router,
              private warehouseService: WarehouseService, private route: ActivatedRoute) {
    this.ppe = new Ppe();
    this.ppe.material = new Material();
    this.material = new Material();
  }

  ngOnInit(): void {
    if (this.route.snapshot.paramMap.get('id') !== undefined && this.route.snapshot.paramMap.get('id') !== null) {
      this.warehouseService.getOneResource("/api/warehouse/ppes" + this.route.snapshot.paramMap.get('id')).subscribe(res => {
        this.ppe = res;
      });
    }
  }

  process() {
    this.ppe.material = this.material;
    console.log(this.ppe);
    this.warehouseService.postResource("/ppes", this.ppe).subscribe(r => {
      this.success = true;
      this.ppe = r;
      this.router.navigate(['/warehouse/ppes/profile/' + this.ppe.id])
    }, () => this.success = false);
  }

  close() {
    this.success = true;
  }
}
