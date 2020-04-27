import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Schedule } from '../model/schedule';
import { Game } from '../model/game';
import { Router } from '@angular/router';
import { PublicContestDetailsService } from '../service/rest/public-contest-details.service';
import { ContestDetailsService } from '../service/rest/contest-details.service';
import { TestBed } from '@angular/core/testing';
import { SignedInService } from '../service/signed-in.service';

@Component({
  selector: 'app-league-of-legends-page',
  templateUrl: './league-of-legends-page.component.html',
  styleUrls: ['./league-of-legends-page.component.css']
})
export class LeagueOfLegendsPageComponent implements OnInit {

  private contests: Array<Contest>;
  private slate: Array<Schedule>;
  private contest: Contest;
  private countdown: string;
  private minus: number;

  constructor(private router: Router,
    private publicContestDetails: PublicContestDetailsService,
    private contestDetailsService: ContestDetailsService,
    private signedInService: SignedInService) {}

  ngOnInit() {
    this.minus = 0;
    let promise = this.publicContestDetails.getPublicContestDetails();
    promise.then(contest => {
      const contestJSON = JSON.parse(JSON.stringify(contest));
      this.contests = this.DTOConversion(contestJSON);

      //Updates every second
      setInterval(() => { this.countdown = this.getCountdown(this.minus); }, 1000);
    });
  }

  /**
   * Handles all of the conversion between the backend and frontend display.
   * @param contestJSON Formatted JSON from the backend
   */
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
      contest.showFlagNameSearch = true;
      contest.showFlagEntryFee = true;
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

  /**
   * Handler for when a contest is clicked ensuring that we pass said ContestID to the drafting page.
   * @param contestId ID of the contest that has been clicked
   */
  selectContest(contestId): void {
    console.log(contestId);
    
    if(!this.signedInService.getStatus()) {
      alert('USER NOT SIGNED IN');
    } else {
      let promise = this.contestDetailsService.getContestDetails(contestId);
  
      promise.then(contest => {
        this.router.navigateByUrl('contest/draft/' + contest.contestId);
      })
    }
  }

  /**
   * Will set a flag for which contests match the slate radio button thats been clicked. 
   * @param clickedSlateTime The value of the slate time which has been clicked on the UI
   */
  slateSelect(clickedSlateTime): void {
    for(let i = 0; i < this.contests.length; i++) {
      if(this.contests[i].schedules[0].slateTime == clickedSlateTime){
        this.contests[i].showFlagSlate = true;
      } else {
        this.contests[i].showFlagSlate = false;
      }
    }
  }

  /**
   * Will set a flag for which contests match the style radio button thats been clicked. 
   * @param gameStyle The value of the style which has been clicked on the UI
   */
  styleSelect(gameStyle): void {
    if(gameStyle == 'Head2Head') {
      for(let i = 0; i < this.contests.length; i++) {
        if(this.contests[i].contestType == 0) {
          this.contests[i].showFlagStyle = true;
        } else {
          this.contests[i].showFlagStyle = false;
        }
      }
    } else if(gameStyle == 'Multiplayer') {
      for(let i = 0; i < this.contests.length; i++) {
        if(this.contests[i].contestType == 1) {
          this.contests[i].showFlagStyle = true;
        } else {
          this.contests[i].showFlagStyle = false;
        }
      }
    }
  }

  /**
   * Called as the user types in the search bar and will filter public contests by the entries
   */
  nameSearch(): void {
    var typedValue = (<HTMLInputElement>document.getElementById("TournamentSearch")).value;

    for(let i = 0; i < this.contests.length; i++) {
      if(this.contests[i].name.includes(typedValue)) {
        this.contests[i].showFlagNameSearch = true;
      } else {
        this.contests[i].showFlagNameSearch = false;
      }
    }
  }

  /**
   * Called as the user types in the Entry Fee box and will filter public contests by the fees
   */
  entryFee(): void {
    var min = (<HTMLInputElement>document.getElementById("TextBoxInputEntryMoneyLeft")).value;
    var max = (<HTMLInputElement>document.getElementById("TextBoxInputEntryMoneyRight")).value;
    var minNum = 0;
    var maxNum = 0;
    if(min == "") {
      min = "0";
      minNum = 0;
    } else {
      minNum = parseInt(min, 10);
    }
    if(max == "") {
      max = "50000";
      maxNum = 50000;
    } else {
      maxNum = parseInt(max, 10);
    }

    for(let i = 0; i < this.contests.length; i++) {
      if(this.contests[i].entryFee >= minNum && this.contests[i].entryFee <= maxNum ) {
        this.contests[i].showFlagEntryFee = true;
      } else {
        this.contests[i].showFlagEntryFee = false;
      }
    }
  }
  
  /**
   * Will sort the Public Contest List by Highest or Lowest Fee's
   * @param sortValue The value of the dropdown button selected
   */
  sortFee(sortValue): void {
    if(sortValue == "low") {
      //Sort the public games list Low to High
      this.contests.sort((a, b) => a.entryFee < b.entryFee ? -1 : a.name > b.name ? 1 : 0)
    } else if(sortValue == "high") {
      //Sort the public games list High to Low
      this.contests.sort((a, b) => a.entryFee > b.entryFee ? -1 : a.name < b.name ? 1 : 0)
    }
  }

  /**
   * Gets the countdown until the contest starts
   */
  getCountdown(minus): string {
    this.minus = minus-1;

    for(let i = 0; i < this.contests.length; i++) {
      if(this.contests[i].showFlagSlate && this.contests[i].showFlagStyle && this.contests[i].showFlagNameSearch && this.contests[i].showFlagEntryFee) {
        // Get milliseconds until contest starts
        let ms = new Date(2020, 4, 8, 14, 33, 30 + minus, 0).getTime() - this.contests[i].schedules[0].startTime.getTime();
    
        /* Days */
        let factor = 1000 * 60 * 60 * 24; // Factor for determining time
        let days = Math.floor(ms / factor); // Get days until contest starts
        ms -= days * factor; // Subtract days from total ms
    
        /* Hours */
        factor /= 24;
        let hours = Math.floor(ms / factor);
        ms -= hours * factor;
    
        /* Minutes */
        factor /= 60;
        let minutes = Math.floor(ms / factor);
        ms -= minutes * factor;
    
        /* Seconds */
        factor /= 60;
        let seconds = Math.floor(ms / factor);
    
        let timer = [days.toString(), hours.toString(), minutes.toString(), seconds.toString()];
    
        /* Pad hours, minutes. seconds with 0's */
        if (hours < 10) timer[1] = '0' + timer[1];
        if (minutes < 10) timer[2] = '0' + timer[2];
        if (seconds < 10) timer[3] = '0' + timer[3];
    
        return timer.join(':');
      }
    }
    return 'Countdown Error';
  }

  public createContest() {
    if (this.signedInService.getStatus()) {
      this.router.navigateByUrl("games/leagueoflegends/contest/create");
    } else {
      alert("SIGN IN");
    }
  }
}