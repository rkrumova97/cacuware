import {Component, OnInit} from '@angular/core';
import {Employee} from "../../../model/employee.model";
import {HrmsService} from "../../../service/hrms.service";
import {DataService} from "../../../service/data.service";
import {Person} from "../../../model/person.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-hire-employee-details',
  templateUrl: './hire-employee-details.component.html',
  styleUrls: ['./hire-employee-details.component.css']
})
export class HireEmployeeDetailsComponent implements OnInit {
  employee!: Employee;
  jobs?: string[];
  education?: string[];
  submitted = false;
  dropdownSettings = {};
  success: boolean = true;


  workingDays = [
    {name: 'Three days a week', value: 3},
    {name: 'Four days a week', value: 4},
    {name: 'Five days a week', value: 5}
  ];
  workingHours = [
    {name: 'Four hours a day', value: 4},
    {name: 'Six hours a day', value: 6},
    {name: 'Eight hours a day', value: 8}
  ];

  constructor(private hrmsService:HrmsService, private dataService: DataService, private router: Router,
              private route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.employee = new Employee(new Person());
    this.employee.person = this.dataService.person!;
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    if(this.route.snapshot.paramMap.get('id')){
      this.hrmsService.getOneResource("/employees/" + this.route.snapshot.paramMap.get('id')).subscribe(res =>{
        this.employee = res;
      });

      console.log(this.employee);
    }

    this.hrmsService.getResource("/jobs").subscribe(res => {
      this.jobs = res;
    });

    this.hrmsService.getResource("/education").subscribe(res => {
      this.education = res;
    });
  }

  process() {
    this.hrmsService.postResource("/employees", this.employee).subscribe((r: Employee) => {
      this.success = true;

      if(this.employee.id){
        this.router.navigate(['/hr/profile/'+this.employee.id]);
      } else  this.router.navigate(['/hr/sensitive-info']);

      this.employee = r;
      this.dataService.employee = this.employee;
      this.dataService.employee.id = r.id;
      console.log(r.id);
    }, error => this.success = false);
  }

  close() {
    this.success = true;
  }
}
