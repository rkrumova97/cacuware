import {Component, OnInit, PipeTransform} from '@angular/core';
import {Employee} from "../../model/employee.model";
import {map, startWith} from "rxjs/operators";
import {Observable} from "rxjs";
import {FormControl} from "@angular/forms";
import {HrmsService} from "../../service/hrms.service";
import {PopupComponent} from "../popup/popup.component";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-fire-employee',
  templateUrl: './fire-employee.component.html',
  styleUrls: ['./fire-employee.component.css']
})
export class FireEmployeeComponent implements OnInit {

  employees$?: Observable<Employee[]>;
  filter = new FormControl('');
  modalService: NgbModal;

  constructor(http: HrmsService,  modalService: NgbModal) {
    this.http = http;
    this.modalService = modalService;
  }

  http: HrmsService;
  employees: Employee[] = [];

  ngOnInit() {
    this.http.getResource('/employees').subscribe(res => {
      this.employees = res;
      console.log(this.employees);
    });

    this.employees$ = this.filter.valueChanges.pipe(
      startWith(''),
      map(text => this.search(text))
    );
  }

   search(text: string): Employee[] {
    return this.employees.filter(employee => {
      const term = text.toLowerCase();
      return employee.person.firstName?.toLowerCase().includes(term)
        || employee.person.middleName?.toLowerCase().includes(term)
        || employee.person.lastName?.toLowerCase().includes(term);
    });
  }

    open(employee: Employee) {
      const modalRef = this.modalService.open(PopupComponent, {centered: true});
      modalRef.componentInstance.employee = employee;
    }
}
