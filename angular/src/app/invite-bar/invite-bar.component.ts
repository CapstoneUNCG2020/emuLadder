import { Component, OnInit, Host } from '@angular/core';
import { Pipe, PipeTransform} from '@angular/core';
import { ContestManagementComponent } from '../contest-management/contest-management.component';
import { Contest } from '../model/contest';
//import { SendEmailService } from '../service/send-email.service';
import { SendEmailService } from '../service/rest/send-email.service';

@Component({
  selector: 'app-invite-bar',
  templateUrl: './invite-bar.component.html',
  styleUrls: ['./invite-bar.component.css']
})
export class InviteBarComponent implements OnInit {

  toEmail: string;
  userEmail: string;
  message: string;
  subject: string;
  error: boolean;
  
  constructor(@Host() private parent: ContestManagementComponent, private sendEmailService: SendEmailService) { }
  
  ngOnInit() {
  }

  getErrorMessage(): string {
      return 'Failed To Send'
  }

  sendEmail(): void {
      let promise = this.sendEmailService.sendEmail(this.toEmail, this.message);
  }

  close() {
    this.parent.showInviteBar = false;
  }
}
