import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Schedule } from '../model/schedule';
import { Game } from '../model/game';
import { Router } from '@angular/router';
import { PublicContestDetailsService } from '../service/rest/public-contest-details.service';
import { ContestDetailsService } from '../service/rest/contest-details.service';
import { TestBed } from '@angular/core/testing';

@Component({
  selector: 'app-league-of-legends-page',
  templateUrl: './league-of-legends-page.component.html',
  styleUrls: ['./league-of-legends-page.component.css']
})
export class LeagueOfLegendsPageComponent implements OnInit {

  private contests: Array<Contest>;
  private tempContests = new Array<Contest>();
  private slate: Array<Schedule>;
  private contest: Contest;

  constructor(private router: Router,
    private publicContestDetails: PublicContestDetailsService,
    private contestDetailsService: ContestDetailsService) {}

  ngOnInit() {
    let promise = this.publicContestDetails.getPublicContestDetails();
    promise.then(contest => {
      const contestJSON = JSON.parse(JSON.stringify(contest));
      console.log(contestJSON);
      this.contests = this.DTOConversion(contestJSON);

      // Updates every second
      // setInterval(() => { this.countdown = this.getCountdown(); }, 1000);
    });
  }

  private DTOConversion(contestJSON): Array<Contest> {
    let contests = new Array<Contest>();
    let schedules = new Array<Schedule>();

    for(let i = 0; i < contestJSON.contests.length; i++){
      let contest = new Contest();
      let schedule = new Schedule();
      contest.contestId = contestJSON.contests[i].contestId;
      contest.name = (contestJSON.contests[i].name == null) ? "Default Name": contestJSON.contests[i].name;
      contest.remainingSpaces = contestJSON.contests[i].currentEntries;
      contest.totalSpaces = contestJSON.contests[i].totalEntries;
      contest.spacePercent = ((contestJSON.contests[i].currentEntries / contestJSON.contests[i].totalEntries) * 100);
      contest.contestType = contestJSON.contests[i].contestType;
      contest.entryFee = contestJSON.contests[i].entreeFee;
      contest.prizeAmount = contestJSON.contests[i].prizeAmount;
      contest.showFlagSlate = true;
      contest.showFlagStyle = true;
      schedule.startTime = new Date(contestJSON.contests[i].start);
      //Checking if any of the times returned from the DB are the same, as we don't want to display 30 of the same times on the screen.
      var flag = true;
      for(let j = 0; j < contests.length; j++){
        if(contests[j].schedules[0].startTime.getTime() === (new Date(contestJSON.contests[i].start)).getTime()){
          flag = false;
        }
      }
      schedule.flag = flag;
      schedule.slateTime = schedule.getStartTime();
      schedule.region = contestJSON.contests[i].region;
      schedules.push(schedule);
      contest.schedules = schedules;
      if(contest.spacePercent != 100){
        contests.push(contest);
      }
      schedules = [];
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

  slateSelect(clickedSlateTime): void {
    console.log(this.contests);
    // this.contests.concat(this.tempContests);
    // this.tempContests = [];

    // let tempIndex = 0;
    for(let i = 0; i < this.contests.length; i++) {
      if(this.contests[i].schedules[0].slateTime == clickedSlateTime){
        this.contests[i].showFlagSlate = true;
        // console.log("Item that is removed: " + this.contests[i].name);
        // this.tempContests[tempIndex] = this.contests[i];
        // tempIndex++;
        // this.contests = this.contests.splice(i, 1);
      } else {
        this.contests[i].showFlagSlate = false;
      }
    }
  }

  styleSelect(gameStyle): void {
    console.log(this.contests);

    console.log(gameStyle);
    console.log(gameStyle == 'Head2Head');
    console.log(gameStyle == 'Multiplayer');
    if(gameStyle == 'Head2Head') {
      for(let i = 0; i < this.contests.length; i++) {
        console.log(this.contests[i].name + " name " + (this.contests[i].contestType == 0) + " ContestType " + this.contests[i].contestType);
        if(this.contests[i].contestType == 0) {
          console.log("In head to head: " + this.contests[i].name);
          this.contests[i].showFlagSlate = true;
        } else {
          this.contests[i].showFlagSlate = false;
        }
      }
    } else if(gameStyle == 'Multiplayer') {
      for(let i = 0; i < this.contests.length; i++) {
        if(this.contests[i].contestType == 1) {
          this.contests[i].showFlagSlate = true;
        } else {
          this.contests[i].showFlagSlate = false;
        }
      }
    }
  }

  /** TODO 
   * ~ Sorting and Filtering Methods
   *  ~ Maybe make a default object that contains everything originally and then when a filter is added move things 
   *    that don't fit in the filter to the secondary object... We display based on this default object....
   */

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
