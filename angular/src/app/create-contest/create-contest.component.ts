import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contest } from '../model/contest';
import { CreateContestService } from '../service/rest/create-contest.service';
import { EventService } from '../service/rest/event.service';

@Component({
  selector: 'app-create-contest',
  templateUrl: './create-contest.component.html',
  styleUrls: ['./create-contest.component.css']
})
export class CreateContestComponent implements OnInit {

  contestType: number;
  opponent: number;
  entryFee: number;
  name: string;
  startTime: string;
  promise: Promise<any>;

  date = "date1"

  private contests: Array<Contest>;
  private events: Array<Contest>;

  constructor(private router: Router, private service: CreateContestService, private event: EventService) { }

  ngOnInit() {
    this.contestType = 0;
    this.opponent = 0;
    this.entryFee = 0;
    this.promise = this.event.getEvents();
    this.promise.then(result => {
      console.log(result);
    })
    
  }

  selectTeam(): void {
    // Head-to-Head -> 0, Public -> 1, Private -> 2
    let contestType = this.contestType == 0 ? 0 : this.opponent == 0 ? 1 : 2;
    
    let promise = this.service.createContest(contestType, this.entryFee, this.name, this.startTime);

    promise.then(contest => {
      this.router.navigateByUrl('contest/draft/' + contest.contestId)
    })
  }
}
