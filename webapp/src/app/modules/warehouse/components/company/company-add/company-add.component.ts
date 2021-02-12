import {Component, OnInit} from '@angular/core';
import {Company} from "../../../model/company.model";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {WarehouseService} from "../../../service/warehouse.service";

@Component({
  selector: 'app-company-add',
  templateUrl: './company-add.component.html',
  styleUrls: ['./company-add.component.css']
})
export class CompanyAddComponent implements OnInit {
  success: boolean = true;
  company!: Company;
  submitted: boolean = false;

  constructor(private http: HttpClient, private router: Router,
              private warehouseService: WarehouseService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.company = new Company();
    if (this.route.snapshot.paramMap.get('id') !== undefined && this.route.snapshot.paramMap.get('id') !== null) {
      this.warehouseService.getOneResource("/api/warehouse/companies" + this.route.snapshot.paramMap.get('id')).subscribe(res => {
        this.company = res;
      });
    }
    console.log(this.route.snapshot.paramMap.get('id'));
  }

  close() {
    this.success = true;
  }

  process() {
    this.warehouseService.postResource("/companies", this.company).subscribe(r => {
      this.success = true;
      this.company = r;
      this.router.navigate(['/warehouse/company/profile/'+this.company.id])
    }, () => this.success = false);
  }
}
