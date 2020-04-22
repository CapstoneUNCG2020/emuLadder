import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Contest } from '../model/contest';
import { CreateContestService } from '../service/rest/create-contest.service';
import { EventService } from '../service/rest/event.service';
import { Events } from 'src/app/model/events';

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
  dateArray: Array<Date>;
  test: Array<string>
  dateObject: Array<object>;

  date = "date1"

  private contests: Array<Contest>;
  private events: Array<Contest>;

  constructor(private router: Router, private service: CreateContestService, private event: EventService) { }

  ngOnInit() {
    this.contestType = 0;
    this.opponent = 0;
    this.entryFee = 0;
    this.dateObject = []
    this.promise = this.event.getEvents();
    this.promise.then(result => {
      for (let res of result) {
        let utc: Date = new Date(res);
        let utcString = utc.toISOString();
        console.log(utcString);
        this.dateObject.push({
          timestamp: new Date(utcString),
          day: this.getDay(new Date(res)),
          date: new Date(res).getUTCDate(),
          time: this.getRegularTime(new Date(res)),
        });
      }
      console.log(this.dateObject);
      console.log(new Date(result[1]).getMinutes())
    })   

  }

  getDay(date: Date): string {
    let days: string[] = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    return days[date.getDay()];
  }

  getRegularTime(date: Date): string {
    let hour: number = date.getHours();
    let min: number = date.getMinutes();
    let stringMin: string = "";
    let realTimeNum: string = "";
    let amOrPm: string = "";
    if (hour > 11) {
      amOrPm = "pm"
    }
    else {
      amOrPm = "am";
    }

    if (min < 10) {
      stringMin = "0" + min;
    }
    else {
      stringMin = "" + min;
    }

    if (hour === 0) {
      return "12:" + stringMin + " " + amOrPm;
    }
    if (hour === 12) {
      return "12:" + stringMin + " " + amOrPm;
    }

    return hour - 12 + ":" + stringMin + " " + amOrPm;
  }

  selectTeam(): void {
    // Head-to-Head -> 0, Public -> 1, Private -> 2
    let contestType = this.contestType == 0 ? 0 : this.opponent == 0 ? 1 : 2;
    console.log(this.startTime);
    let promise = this.service.createContest(contestType, this.entryFee, this.name, this.startTime);

    promise.then(contest => {
      this.router.navigateByUrl('contest/draft/' + contest.contestId)
    })
  }
}
