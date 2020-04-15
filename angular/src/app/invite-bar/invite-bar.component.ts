import { Component, OnInit, Host } from '@angular/core';
import { Pipe, PipeTransform} from '@angular/core';
import { ContestManagementComponent } from '../contest-management/contest-management.component';
import { Contest } from '../model/contest';
//import { SendEmailService } from '../service/SendEmailService.service';

@Component({
  selector: 'app-invite-bar',
  templateUrl: './invite-bar.component.html',
  styleUrls: ['./invite-bar.component.css']
})
export class InviteBarComponent implements OnInit {

  Email: String;
  
  constructor(@Host() private parent: ContestManagementComponent) { }

  ngOnInit() {
  }

  close() {
    this.parent.showInviteBar = false;
  }
}
