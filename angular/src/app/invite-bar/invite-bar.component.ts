import { Component, OnInit, Host } from '@angular/core';
import { Pipe, PipeTransform} from '@angular/core';
import { ContestManagementComponent } from '../contest-management/contest-management.component';
import { Contest } from '../model/contest';
//import { SendEmailService } from '../service/send-email.service';
import { SendEmailService } from '../service/rest/send-email.service';
import { SentEmailService } from '../service/sent-email.service';
import { EmailValidator } from '@angular/forms';

@Component({
  selector: 'app-invite-bar',
  templateUrl: './invite-bar.component.html',
  styleUrls: ['./invite-bar.component.css']
})
export class InviteBarComponent implements OnInit {

  toEmail: string;
  userEmail: string;
  message: string = "Link Goes here!";
  subject: string = "You've Been invited to EmuLadder!";
  error: boolean;
  
  constructor(@Host() private parent: ContestManagementComponent, private sendEmailService: SendEmailService, private sentEmailService: SentEmailService) { }
  
  ngOnInit() {
  }

  getErrorMessage(): string {
      return 'Failed To Send'
  }

  sendEmail(): void {
      let promise = this.sendEmailService.sendEmail(this.toEmail, this.message);

      promise.then(success => {
        if (success) {
          this.sentEmailService.sent();
          this.close();
        } else {
          this.error = true;
        }
      });
  }


  close() {
    this.parent.showInviteBar = false;
  }
}
