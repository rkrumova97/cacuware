import {Component, OnInit} from '@angular/core';
import {Employee} from "../../model/employee.model";
import {HrmsService} from "../../service/hrms.service";
import {ActivatedRoute} from "@angular/router";
import {Person} from "../../model/person.model";
import {SecurityDataModel} from "../../model/security-data.model";
import {DataService} from "../../service/data.service";
import {FileService} from "../../service/file.service";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  id?: string | null;
  employee!: Employee;
  files: any[] = [];
  http: HrmsService;

  constructor(private route: ActivatedRoute, http: HrmsService, private dataService:DataService, private fileService: FileService) {
    this.http = http;
  }

  ngOnInit() {
    this.employee = new Employee(new Person(), new SecurityDataModel());

    this.id = this.route.snapshot.paramMap.get('id');
    this.http.getOneResource('/employees/' + this.id).subscribe(res => {
      this.employee = res;
      this.dataService.employee = res;
      this.dataService.employee.id= this.id;
      console.log(this.dataService.employee);
    });

    this.fileService.getFiles().subscribe(res => {
      this.files = res;

    });
  }


}
