import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CreateContestService } from '../service/rest/create-contest.service';
import { EventService } from '../service/rest/event.service';
import { Events } from 'src/app/model/events';
import { SignedInService } from '../service/signed-in.service';

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
  eventArray: Array<Events>;
  groupedEvents: Array<Array<object>>;
  dates: string;
  error = "Loading contests...";

  constructor(private router: Router, private service: CreateContestService, private event: EventService,
    private signedInService: SignedInService, ) { }

  ngOnInit() {
    // Only work if signed in.
    if (this.signedInService.getStatus()) {
      this.contestType = 0;
      this.opponent = 0;
      this.entryFee = 0;
      this.name = "";
      let promise: Promise<any> = this.event.getEvents();
      promise.then(result => {
        this.dateObject = [];
        let i: number = 1;
        for (let res of result) {
          this.dateObject.push({
            id: i,
            timestamp: res,
            day: this.getDay(new Date(res)),
            date: new Date(res).toLocaleDateString(),
            time: this.getRegularTime(new Date(res)),
          });
          i++;
        }
        console.log("hello")
        let eventsPromise = this.event.getLatestEvents();
        eventsPromise.then(eventsData => {
          this.dates = '';
          let x: number = 0;
          this.groupedEvents = [];
          let tempDate: string = new Date(eventsData[0].startTime).toUTCString().substring(0, 16)

          for (let i = 0; i < result.length; i++) {
            let tempObject: Array<object> = [];
            for (let j = x; j < eventsData.length; j++) {
              if (tempDate == new Date(eventsData[j].startTime).toUTCString().substring(0, 16)) { // compare actual UTC date
                tempObject.push({
                  teamCode: eventsData[j].teamCode,
                  teamCode2: eventsData[j].teamCode2,
                  date: new Date(eventsData[j].startTime).toLocaleDateString(),
                  time: this.getRegularTime(new Date(eventsData[j].startTime))
                });
              }
              else {
                x = j; // save current index
                tempDate = new Date(eventsData[j].startTime).toUTCString().substring(0, 16); // set tempDate to date that mismatched
                break;
              }
            }
            this.groupedEvents.push(tempObject);
            tempObject = []; // remove all data from inner loop that was stored in tempObject
          }
        });
      });

    } else {
      this.error = "You must be signed in.";
    }
  }

  getDay(date: Date): string {
    let days: string[] = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    return days[date.getDay()];
  }

  getRegularTime(date: Date): string {
    let hour: number = date.getHours();
    let min: number = date.getMinutes();
    let stringMin: string = "";
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
    let promise = this.service.createContest(contestType, this.entryFee, this.name, this.startTime);

    promise.then(contest => {
      this.router.navigateByUrl('contest/draft/' + contest.contestId)
    })
  }
}
