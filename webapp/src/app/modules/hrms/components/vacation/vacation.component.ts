import {Component, OnInit} from '@angular/core';
import {Employee} from "../../model/employee.model";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ApplicationForVacation} from "../../model/application-for-vacation.model";
import {HrmsService} from "../../service/hrms.service";
import {FileService} from "../../service/file.service";
import {EmailService} from "../../service/email.service";

@Component({
  selector: 'app-vacation',
  templateUrl: './vacation.component.html',
  styleUrls: ['./vacation.component.css']
})
export class VacationComponent implements OnInit {

  employees?: Employee[];
  employee?: Employee;
  id?: string;
  http: HttpClient;
  router: Router;
  application!: ApplicationForVacation;

  constructor(http: HttpClient, router: Router, private hrmsService: HrmsService,
              private fileService: FileService, private emailService: EmailService) {
    this.http = http;
    this.router = router;
  }

  ngOnInit() {
    this.application = new ApplicationForVacation();

    this.hrmsService.getResource("/employees").subscribe(res => {
      this.employees = res;
    });

  }

  onSubmit() {
    this.hrmsService.updateResource("/employees/vacation", this.application).subscribe(() => {
      this.fileService.generateVacationDocuments(this.application).subscribe(() => {
        this.emailService.sendHireEmail(this.employee).subscribe();
      });
    });
  }

  selectChangeHandler(event: any) {
    this.id = event.target.value;
    this.hrmsService.getOneResource("/employees/"+this.id!).subscribe(r =>  {
      this.employee = r;
      if(this.employee){
        this.employee.id = this.id;
        this.application.employee = this.employee;
      }
      console.log(this.employee)
    });
  }
}
