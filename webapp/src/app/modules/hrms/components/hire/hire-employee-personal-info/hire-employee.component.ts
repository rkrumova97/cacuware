import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {Person} from "../../../model/person.model";
import {HrmsService} from "../../../service/hrms.service";
import {DataService} from "../../../service/data.service";


@Component({
  selector: 'app-hire-employee',
  templateUrl: './hire-employee.component.html',
  styleUrls: ['./hire-employee.component.css']
})
export class HireEmployeeComponent implements OnInit {

  grades?: string[];
  http: HttpClient;
  person?: Person;
  genders = ['Male', 'Female', 'Other'];
  router: Router;
  dropdownSettings = {};

  submitted = false;
  success: boolean = true;

  constructor(http: HttpClient, router: Router, private hrmsService: HrmsService,
              private dataService: DataService, private route: ActivatedRoute) {
    this.http = http;
    this.router = router;
  }

  ngOnInit() {
    this.person = new Person();
    if(this.route.snapshot.paramMap.get('id') !== undefined || this.route.snapshot.paramMap.get('id') !== undefined){
       this.hrmsService.getOneResource("/persons/" + this.route.snapshot.paramMap.get('id')).subscribe(res =>{
         this.person = res;
       });
    }
  }

  process(): void {
    this.hrmsService.postResource("/persons", this.person).subscribe(r => {
      this.router.navigate(['/hr/employee-details']);
      this.success = true;
      this.person = r;
      this.dataService.person = this.person!;
      this.dataService.person.id = r.id;
    }, error => this.success = false);
  }

  close() {
    this.success = true;
  }
}
