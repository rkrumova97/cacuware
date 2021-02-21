import { Component, OnInit } from '@angular/core';
import {FileService} from "../../service/file.service";
import * as fileSaver from "file-saver";

@Component({
  selector: 'app-give-salary',
  templateUrl: './give-salary.component.html',
  styleUrls: ['./give-salary.component.css']
})
export class GiveSalaryComponent implements OnInit {
  fileInfos: any;

  constructor( private uploadService: FileService) { }

  ngOnInit(): void {
    this.uploadService.getFiles().subscribe(file => {
      this.fileInfos = file;
    });
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

}
