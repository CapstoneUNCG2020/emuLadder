import { Component, OnInit } from '@angular/core';
import { Pipe, PipeTransform} from '@angular/core';

@Component({
  selector: 'app-invite-bar',
  templateUrl: './invite-bar.component.html',
  styleUrls: ['./invite-bar.component.css']
})
export class InviteBarComponent implements OnInit {

  showInviteBar: boolean;
  searchString: String;
  constructor() { }

  ngOnInit() {
  }

}
