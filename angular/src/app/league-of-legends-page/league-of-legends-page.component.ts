import { Component, OnInit, wtfStartTimeRange } from '@angular/core';
import { Contest } from '../model/contest';
import { Schedule } from '../model/schedule';
import { Game } from '../model/game';
import { Router } from '@angular/router';

@Component({
  selector: 'app-league-of-legends-page',
  templateUrl: './league-of-legends-page.component.html',
  styleUrls: ['./league-of-legends-page.component.css']
})
export class LeagueOfLegendsPageComponent implements OnInit {

  private contests: Array<Contest>;
  private slate: Array<Schedule>;

  constructor(private router: Router) { }

  ngOnInit() {
    this.contests = this.getPublicContest();
  }

  private getPublicContest(): Array<Contest> {
    let contests = new Array<Contest>();
    let schedules = new Array<Schedule>();

    let contest = new Contest();
    let schedule = new Schedule();
    contest.name = 'JACKPOT LOL Tournament';
    contest.currentEntries = 10;
    contest.maxEntries = 20;
    contest.type = 'Multiplayer';
    contest.entryFee = 1000;
    contest.prizeAmount = 100000;
    schedule.startTime = this.getTime();
    schedule.region = 'LCS';
    schedule.teamCode1 = 'MAD';
    schedule.teamCode2 = 'G2';
    schedule.slateTime = schedule.getStartTime();
    schedules.push(schedule);

    contest.schedules = schedules;
    contests.push(contest);
    schedules = [];

    contest = new Contest();
    schedule = new Schedule();
    contest.name = 'Public League of Legends Tournament 1';
    contest.currentEntries = 1;
    contest.maxEntries = 2;
    contest.type = 'Head-to-Head';
    contest.entryFee = 10;
    contest.prizeAmount = 20;
    schedule.startTime = this.getTime();
    schedule.region = 'LCS';
    schedule.teamCode1 = 'C9';
    schedule.teamCode2 = 'TSM';
    schedule.slateTime = schedule.getStartTime();
    schedules.push(schedule);

    contest.schedules = schedules;
    contests.push(contest);
    schedules = [];

    contest = new Contest();
    schedule = new Schedule();
    contest.name = 'Wilmoth LOL Tournament';
    contest.currentEntries = 5;
    contest.maxEntries = 12;
    contest.type = 'Multiplayer';
    contest.entryFee = 100;
    contest.prizeAmount = 1000;
    schedule.startTime = this.getTime();
    schedule.region = 'LCK';
    schedule.teamCode1 = 'POG';
    schedule.teamCode2 = 'SKT';
    schedule.slateTime = schedule.getStartTime();
    schedules.push(schedule);

    contest.schedules = schedules;
    contests.push(contest);
    schedules = [];

    contest = new Contest();
    schedule = new Schedule();
    contest.name = 'Public League of Legends Tournament 2';
    contest.currentEntries = 4;
    contest.maxEntries = 10;
    contest.type = 'Multiplayer';
    contest.entryFee = 50;
    contest.prizeAmount = 500;
    schedule.startTime = this.getTime();
    schedule.region = 'OCE';
    schedule.teamCode1 = 'RAM';
    schedule.teamCode2 = 'UND';
    schedule.slateTime = schedule.getStartTime();
    schedules.push(schedule);

    contest.schedules = schedules;
    contests.push(contest);
    schedules = [];
    
    return contests;
  }

  private getTime(): Date {
    let time = new Date();
    time.setHours(12);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(4);
    time.setDate(8);
    time.setFullYear(2020);

    return time;
  }

}
