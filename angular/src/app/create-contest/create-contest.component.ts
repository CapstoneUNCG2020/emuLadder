import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
<<<<<<< HEAD
import { Contest } from '../model/contest';
=======
import { CreateContestService } from '../service/rest/create-contest.service';
>>>>>>> 3775ac989c66d566147e748d8853f299b171a68d

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

  date = "date1"

  private contests: Array<Contest>;
  private events: Array<Contest>;

  dateTimes = [
    {
      day: 'Saturday',
      date: 'Jan 25th',
      time: '5:00pm',
      teams: ["FLY v IMT", "C9 v NRG", "G2 v FaZe"],
      dateAndTime: ["1/25 5:00pm", "1/25 5:50pm", "1/25 6:40pm"]
    },
    {
      day: 'Sunday',
      date: 'Jan 26th',
      time: '6:00pm',
      teams: ["GG v 100", "CLG v GG", "TSM v DIG", "C9 v G2"],
      dateAndTime: ["1/26 5:00pm", "1/26 5:50pm", "1/26 6:40pm", "1/26 7:30pm"]
    },
    {
      day: 'Friday',
      date: 'Jan 30th',
      time: '5:00pm',
      teams: ["FLY v IMT", "C9 v TSM", "DIG v CLG", "GG v 100", "NRG v eU"],
      dateAndTime: ["1/30 3:00pm", "1/30 3:50pm", "1/30 4:40pm", "1/30 5:30pm", "1/30 6:20pm"]
    },
    {
      day: 'Friday',
      date: 'Feb 7th',
      time: '7:00pm',
      teams: ["G2 v NRG", "TSM v DIG", "eU v C9", "100 v FaZe"],
      dateAndTime: ["2/7 3:00pm", "2/7 3:50pm", "2/7 4:40pm", "2/7 5:30pm"]
    },
    {
      day: 'Saturday',
      date: 'Feb 15th',
      time: '6:00pm',
      teams: ["TSM v 100", "eU v GG", "C9 v DIG"],
      dateAndTime: ["2/15 5:00pm", "2/15 5:50pm", "2/15 6:40pm"]
    }
  ]

  constructor(private router: Router, private service: CreateContestService) { }

  ngOnInit() {
    this.contestType = 0;
    this.opponent = 0;
    this.entryFee = 0;
    this.startTime = '2020-02-09T12:00:00'
  }

  getContests(): Array<Contest> {
    let contests = new Array<Contest>;

    let contest = new Contest();
    let time = new Date();
    time.setHours(17);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(1);
    time.setDate(26);
    time.setFullYear(2020);

    contest.startTime = time;
    contests.push(contest);

    contest = new Contest();
    time = new Date();
    time.setHours(17);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(1);
    time.setDate(26);
    time.setFullYear(2020);

    contest.startTime = time;
    contests.push(contest);

    contest = new Contest();
    time = new Date();
    time.setHours(17);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(1);
    time.setDate(26);
    time.setFullYear(2020);

    contest.startTime = time;
    contests.push(contest);

    contest = new Contest();
    time = new Date();
    time.setHours(17);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(1);
    time.setDate(26);
    time.setFullYear(2020);

    contest.startTime = time;
    contests.push(contest);

    contest = new Contest();
    time = new Date();
    time.setHours(17);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(1);
    time.setDate(26);
    time.setFullYear(2020);

    contest.startTime = time;
    contests.push(contest);

    return contests;
  }

  getEvents(): Array<Event> {
    
  }

  getDay(date: Date): string {
    let days: string[] = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']
    return days[date.getDay()];
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
