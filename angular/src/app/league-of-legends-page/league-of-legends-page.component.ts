import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Schedule } from '../model/schedule';
import { Game } from '../model/game';
import { Router } from '@angular/router';
import { PublicContestDetailsService } from '../service/rest/public-contest-details.service';
import { ContestDetailsService } from '../service/rest/contest-details.service';

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
    private publicContestDetails: PublicContestDetailsService,
    private contestDetailsService: ContestDetailsService) { }

  ngOnInit() {
    let promise = this.publicContestDetails.getPublicContestDetails();
    promise.then(contest => {
      const contestJSON = JSON.parse(JSON.stringify(contest));
      this.contests = this.testing(contestJSON);

      // Updates every second
      // setInterval(() => { this.countdown = this.getCountdown(); }, 1000);
    });
  }

  private testing(contestJSON): Array<Contest> {
    let contests = new Array<Contest>();
    let schedules = new Array<Schedule>();

    for(let i = 0; i < contestJSON.contests.length; i++){
      let contest = new Contest();
      contest.contestId = contestJSON.contests[i].contestId;
      contest.name = contestJSON.contests[i].name;
      contest.remainingSpaces = contestJSON.contests[i].currentEntries;
      contest.totalSpaces = contestJSON.contests[i].totalEntries;
      contest.spacePercent = ((contestJSON.contests[i].currentEntries / contestJSON.contests[i].totalEntries) * 100);
      contest.contestType = 1;
      contest.entryFee = contestJSON.contests[i].entreeFee;
      contest.prizeAmount = contestJSON.contests[i].prizeAmount;
      contests.push(contest);
    }
    
    return contests;
  }



  selectContest(contestId): void {
    console.log(contestId);
    
    let promise = this.contestDetailsService.getContestDetails(contestId);

    promise.then(contest => {
      this.router.navigateByUrl('contest/draft/' + contest.contestId);
    })
  }




/**
 * OLD CODE THAT I'M STILL REFERENCING
 */

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
