import { Component, OnInit } from '@angular/core';
import { ProcessPensionInput } from 'src/app/models/process-pension-input';
import { ProcessPensionResponse } from 'src/app/models/process-pension-response';
import { AuthService } from 'src/app/services/auth.service';
import { ProcessPensionService } from 'src/app/services/process-pension.service';
import { SweetAlert } from 'sweetalert/typings/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-process-pension',
  templateUrl: './process-pension.component.html',
  styleUrls: ['./process-pension.component.css']
})
export class ProcessPensionComponent implements OnInit {

  constructor(
    private pservice: ProcessPensionService,
    private authservice: AuthService,
  ) { }

  msg: string = ''
  color: String = ''
  fieldErrors: string[] = []

  ngOnInit(): void {
  }

  handleReset() {
    this.msg = ""
    this.fieldErrors = []
  }

  processPensionResponse = new ProcessPensionResponse(21);
  processPensionInput = new ProcessPensionInput("", 0, 0);

  handleProcessPensionInput() {
    this.pservice.processPension(this.processPensionInput)
      .subscribe(
        data => {
          this.processPensionResponse = data
          if (this.processPensionResponse.processPensionStatusCode == 10) {
            this.msg = "Pension disbursement Success"
            this.color = "text-success"
            Swal.fire(
              'Success !',
              'Pension disbursement Success!',
              'success'
            )
          }
          else {
            this.msg = "Pension amount calculated is wrong \n Please redo the calculation"
            this.color = "text-danger"
            Swal.fire(
              'Error !',
              'Pension amount calculated is wrong! Please Redo !!',
              'error'
            )
          }
          console.log(this.processPensionResponse);
        },
        error => {
          try {
            // get the errors thrown by the server
            this.fieldErrors = error.fieldErrors;
            console.log(this.fieldErrors);
            if (this.fieldErrors.length == 1) {
              this.logoutIfTokenExpired(this.fieldErrors[0])
            }
          } catch (e) {
            // feign error if field error can't be parsed ...
            this.msg = "Service is down, please try again later..."
            this.color = "text-danger"
            console.log(this.msg);
          }
        }
      );
  }

  logoutIfTokenExpired(error: String) {
    if (error.includes("expired")) {
      alert("Your session has been expired... Logging out!");
      this.authservice.logout();
    }
  }
}
