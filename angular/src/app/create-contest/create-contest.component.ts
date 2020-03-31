import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-contest',
  templateUrl: './create-contest.component.html',
  styleUrls: ['./create-contest.component.css']
})
export class CreateContestComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  selectTeam(): void {
    this.router.navigateByUrl('contest/draft')
  }
}
