import {Component, OnInit, Query} from '@angular/core';
import {Employee} from "../../model/employee.model";
import {Router} from "@angular/router";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ApplicationForVacation} from "../../model/application-for-vacation.model";

@Component({
  selector: 'app-vacation',
  templateUrl: './vacation.component.html',
  styleUrls: ['./vacation.component.css']
})
export class VacationComponent implements OnInit {

  employees?: Employee[];
  http: HttpClient;
  router: Router;
  modalService: NgbModal;

  application!: ApplicationForVacation;

  constructor(http: HttpClient, router: Router,modalService: NgbModal) {
    this.http = http;
    this.router = router;
    this.modalService = modalService;
  }

  ngOnInit() {
    this.application = new ApplicationForVacation();

    this.http.get<Employee[]>('http://localhost:8080/createApplication').subscribe(res => {
      this.employees = res;
    });
  }

  onSubmit() {
    console.log(JSON.stringify(this.application));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json;charset=UTF-8',
      })
    };
    this.http.post<Query>('http://localhost:8080/createApplication', JSON.stringify(this.application), httpOptions)
      .subscribe(r => {
        console.log(r);
        this.router.navigate(['/employee']);
      });
  }

}
