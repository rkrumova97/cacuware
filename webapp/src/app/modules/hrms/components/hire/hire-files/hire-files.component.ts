import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {DataService} from "../../../service/data.service";
import {FileService} from "../../../service/file.service";
import {HttpErrorResponse, HttpEvent, HttpEventType, HttpResponse} from "@angular/common/http";
import {catchError, map} from "rxjs/operators";
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-hire-files',
  templateUrl: './hire-files.component.html',
  styleUrls: ['./hire-files.component.css']
})
export class HireFilesComponent implements OnInit {
  success: boolean = true;
  id?: string;
  selectedFiles?: FileList;
  currentFile!: File | null;
  progress = 0;
  message = '';
  type: string = "";

  fileInfos?: Observable<any>;

  @ViewChild("fileUpload", {static: false}) fileUpload!: ElementRef;
  files: any = [];

  constructor(private dataService: DataService, private uploadService: FileService) {
  }

  ngOnInit(): void {
    this.id = this.dataService.employee?.id;
  }

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }

  upload(type:string): void {
    this.progress = 0;

    this.currentFile = this.selectedFiles!.item(0);
    this.uploadService.upload(type, this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          // @ts-ignore
          this.progress = Math.round(100 * event.loaded / event.total);
          console.log(this.progress);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
          this.fileInfos = this.uploadService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = null;
      });

    this.selectedFiles = undefined;
  }

  close() {
    this.success = true;
  }
}
