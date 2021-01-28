import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {DataService} from "../../../service/data.service";
import {FileService} from "../../../service/file.service";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import * as fileSaver from 'file-saver';
import {Observable} from "rxjs";
import {Employee} from "../../../model/employee.model";
import {HrmsService} from "../../../service/hrms.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Person} from "../../../model/person.model";
import {SecurityDataModel} from "../../../model/security-data.model";
import {EmailService} from "../../../service/email.service";

@Component({
  selector: 'app-hire-files',
  templateUrl: './hire-files.component.html',
  styleUrls: ['./hire-files.component.css']
})
export class HireFilesComponent implements OnInit {
  success: boolean = true;
  submitted = false;
  employee: Employee | undefined;
  selectedFiles?: FileList;
  currentFile!: File | null;
  progress = 0;
  message = '';
  dropdownSettings = {};
  documentTypes: Observable<any[]> | undefined;
  form: FormGroup;
  type: string = "";

  fileInfos: any[] = [];

  @ViewChild("fileUpload", {static: false}) fileUpload!: ElementRef;
  files: any = [];

  constructor(private dataService: DataService, private employeeService: HrmsService,
              private uploadService: FileService, private formBuilder: FormBuilder,
              private mailService: EmailService) {
    this.form = this.formBuilder.group({
      type: ['']
    });

    // async orders

    this.uploadService.getFileTypes().subscribe(res => {
      this.documentTypes = res;
      console.log(res);
      if (this.documentTypes) {
        this.form.controls.orders.patchValue(this.documentTypes[0]);
      }
    });
  }

  ngOnInit(): void {
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

    this.employee = new Employee(new Person(), new SecurityDataModel(), "");
    this.employee = this.dataService.employee;
    this.employee!.fileIds = [];

    this.uploadService.generateDocuments(this.employee).subscribe(file => {
      this.fileInfos = file;
      this.fileInfos.forEach(f => {
        this.employee!.fileIds = [];
        this.employee!.fileIds.push(f.id);
      })
    });

  }

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }

  upload(): void {
    this.progress = 0;
    console.log(this.form.value);
    this.currentFile = this.selectedFiles!.item(0);
    this.uploadService.upload(this.form.get('type')?.value, this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          // @ts-ignore
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
          this.employee?.fileIds?.push(event.body.id);
          this.employeeService.postResource("/employees", this.employee).subscribe(() =>{
            this.uploadService.getFilesByIDs( this.employee?.fileIds!).subscribe(file => {
              this.fileInfos = file;
              this.fileInfos.forEach(f => {
                this.employee!.fileIds = [];
                this.employee!.fileIds.push(f.id);
              })
            });
          });
        }
      },
      () => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = null;
      });
    this.selectedFiles = undefined;
  }

  close() {
    this.employeeService.postResource("/employees", this.employee);
    this.success = true;
  }

  download(url: any, fileName: any) {
    console.log(url);

    this.uploadService.download(url).subscribe((response: Blob) => {
      console.log(response);
      let blob: any = new Blob([response], {type: response.type});
      fileSaver.saveAs(blob, fileName);
    }), () => console.log('Error downloading the file'),
      () => console.info('File downloaded successfully');
  }

  finish() {
    this.mailService.sendHireEmail(this.employee).subscribe();
  }
}
