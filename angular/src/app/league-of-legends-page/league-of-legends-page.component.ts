import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Schedule } from '../model/schedule';
import { Game } from '../model/game';
import { Router } from '@angular/router';
import { PublicContestDetailsService } from '../service/rest/public-contest-details.service';

@Component({
  selector: 'app-league-of-legends-page',
  templateUrl: './league-of-legends-page.component.html',
  styleUrls: ['./league-of-legends-page.component.css']
})
export class LeagueOfLegendsPageComponent implements OnInit {

  private contests: Array<Contest>;
  private slate: Array<Schedule>;
  private contest: Contest;

  constructor(private router: Router,
    private publicContestDetails: PublicContestDetailsService) { }

  ngOnInit() {
    let promise = this.publicContestDetails.getPublicContestDetails();
    promise.then(contest => {
      const test = JSON.parse(JSON.stringify(contest));
      console.log(test);
      console.log("SPACE");
      console.log(test.contests[0]);

      this.contests = this.testing(test);


      // let contestString = JSON.stringify(contest);
      // console.log(contestString);
      // let contestObj = Object.assign(new Contest(), JSON.parse(contestString));

      // this.contest = contestObj;
      // console.log(this.contest);
      // console.log("SPACE");
      // console.log(this.contest[0]);

      // this.contests = this.testBackendResponse();

      // Updates every second
      // setInterval(() => { this.countdown = this.getCountdown(); }, 1000);
    });
  }

  private testing(test): Array<Contest> {
    let contests = new Array<Contest>();
    let schedules = new Array<Schedule>();

    let contest = new Contest();
    contest.name = test.contests[0].name;
    contest.remainingSpaces = (test.contests[0].totalEntries - test.contests[0].currentEntries);
    contest.totalSpaces = test.contests[0].totalEntries;
    contest.contestType = 2;
    contest.entryFee = test.contests[0].entreeFee;
    contest.prizeAmount = test.contests[0].prizeAmount;
    contests.push(contest);

    return contests;
  }

  // private testBackendResponse(): Array<Contest> {
  //   let contests = new Array<Contest>();
  //   let schedules = new Array<Schedule>();

  //   let tempContest = new Contest();
  //   tempContest.name = this.contest.name;
  //   tempContest.remainingSpaces = this.contest.remainingSpaces;
  //   tempContest.totalSpaces = 20;
  //   tempContest.contestType = 1;
  //   tempContest.entryFee = 1000;
  //   tempContest.prizeAmount = 100000;
  // } 

  // private getPublicContest(): Array<Contest> {
  //   let contests = new Array<Contest>();
  //   let schedules = new Array<Schedule>();

  //   let contest = new Contest();
  //   let schedule = new Schedule();
  //   contest.name = 'JACKPOT LOL Tournament';
  //   contest.remainingSpaces = 10;
  //   contest.totalSpaces = 20;
  //   contest.contestType = 1;
  //   contest.entryFee = 1000;
  //   contest.prizeAmount = 100000;
  //   schedule.startTime = this.getTime();
  //   schedule.region = 'LCS';
  //   schedule.teamCode1 = 'MAD';
  //   schedule.teamCode2 = 'G2';
  //   schedule.slateTime = schedule.getStartTime();
  //   schedules.push(schedule);

  //   contest.schedules = schedules;
  //   contests.push(contest);
  //   schedules = [];

  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 1';
  //   contest.remainingSpaces = 1;
  //   contest.totalSpaces = 2;
  //   contest.contestType = 0;
  //   contest.entryFee = 10;
  //   contest.prizeAmount = 20;
  //   schedule.startTime = this.getTime2();
  //   schedule.region = 'LCS';
  //   schedule.teamCode1 = 'C9';
  //   schedule.teamCode2 = 'TSM';
  //   schedule.slateTime = schedule.getStartTime();
  //   schedules.push(schedule);

  //   contest.schedules = schedules;
  //   contests.push(contest);
  //   schedules = [];

  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Wilmoth LOL Tournament';
  //   contest.remainingSpaces = 5;
  //   contest.totalSpaces = 12;
  //   contest.contestType = 1;
  //   contest.entryFee = 100;
  //   contest.prizeAmount = 1000;
  //   // schedule.startTime = this.getTime();
  //   // schedule.region = 'LCK';
  //   // schedule.teamCode1 = 'POG';
  //   // schedule.teamCode2 = 'SKT';
  //   // schedule.slateTime = schedule.getStartTime();
  //   // schedules.push(schedule);

  //   // contest.schedules = schedules;
  //   contests.push(contest);
  //   // schedules = [];

  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   // schedule.startTime = this.getTime();
  //   // schedule.region = 'OCE';
  //   // schedule.teamCode1 = 'RAM';
  //   // schedule.teamCode2 = 'UND';
  //   // schedule.slateTime = schedule.getStartTime();
  //   // schedules.push(schedule);

  //   // contest.schedules = schedules;
  //   contests.push(contest);
  //   // schedules = [];

  //   //REPEAT
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
  //   contest = new Contest();
  //   schedule = new Schedule();
  //   contest.name = 'Public League of Legends Tournament 2';
  //   contest.remainingSpaces = 4;
  //   contest.totalSpaces = 10;
  //   contest.contestType = 1;
  //   contest.entryFee = 50;
  //   contest.prizeAmount = 500;
  //   contests.push(contest);
    
  //   return contests;
  // }

  // private getTime(): Date {
  //   let time = new Date();
  //   time.setHours(12);
  //   time.setMinutes(0);
  //   time.setSeconds(0);
  //   time.setMilliseconds(0);
  //   time.setMonth(4);
  //   time.setDate(8);
  //   time.setFullYear(2020);

  //   return time;
  // }

  // private getTime2(): Date {
  //   let time = new Date();
  //   time.setHours(18);
  //   time.setMinutes(0);
  //   time.setSeconds(0);
  //   time.setMonth(4);
  //   time.setDate(9);
  //   time.setFullYear(2020);

  //   return time;
  // }

}
