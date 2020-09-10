import {Component, OnInit} from '@angular/core';
import {Employee} from "../../model/employee.model";
import {Router} from "@angular/router";
import {HrmsService} from "../../service/hrms.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-list-employees',
  templateUrl: './list-employees.component.html',
  styleUrls: ['./list-employees.component.css']
})
export class ListEmployeesComponent implements OnInit {

  employees?: Employee[];
  hrmsService: HrmsService;
  employee?: Employee;
  isClicked?: boolean;
  router: Router;
  modalService: NgbModal;

  constructor(hrmsService: HrmsService, router: Router, modalService: NgbModal) {
    this.hrmsService = hrmsService;
    this.router = router;
    this.modalService = modalService;
  }

  ngOnInit() {
    this.isClicked = true;
    this.hrmsService.getResource("/employees").subscribe(res => {
      this.employees = res;
    });

  }

  toggle({employee}: { employee: any }): boolean {
    employee.show = !employee.show;
    return true;
  }

  updateList(employee: Employee, property: string, event: any) {
    employee[property] = event.target.textContent;
    console.log(JSON.stringify(this.employees));
    this.hrmsService.postResource("/employees", employee)
      .subscribe(r => {
        console.log(r);
      });
  }

  open(firstName: string, middleName: string, lastName: string, id: string) {

  }
}
