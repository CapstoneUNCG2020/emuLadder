import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Router } from '@angular/router';
import { RegisteredContestService } from '../service/rest/registered-contest.service';
import { RegisteredContests } from '../model/registered-contests';
import { SignedInService } from '../service/signed-in.service';

@Component({
  selector: 'app-contest-management',
  templateUrl: './contest-management.component.html',
  styleUrls: ['./contest-management.component.css']
})
export class ContestManagementComponent implements OnInit {

  contests: Array<RegisteredContests>;
  public showInviteBar: boolean;
  error = "Loading contests...";

  constructor(private router: Router, private service: RegisteredContestService,
    private signedInService: SignedInService) { }

  ngOnInit() {
    // Only work if signed in.
    if (this.signedInService.getStatus()) {
      let promise = this.service.getRegisteredContests();

      promise.then(response => {
        this.contests = response;
      });
    } else {
      this.error = "You must be signed in.";
    }
  }

  valueOf(n: number): string {
    return n.toLocaleString();
  }

  getEntryFees(): string {
    if (this.contests == undefined || this.contests.length == 0) {
      return this.valueOf(0);
    }

    
    let sum = this.contests.map(x => x.contest.entryFee).reduce((a, b) => a = b);

    return this.valueOf(sum);
  }

  editContest(contest: Contest) {
    let url = 'contest/draft/' + contest.contestId;

    this.router.navigateByUrl(url);
  }

  invite(): void {
    this.showInviteBar = true;
  }

  getRank(contest: RegisteredContests): string {
    return this.getOrdinal(contest.rank) + ' place'
  }

  private getOrdinal(i: number): string {
    let j = i % 10,
        k = i % 100;
    if (j == 1 && k != 11) {
        return i + "st";
    }
    if (j == 2 && k != 12) {
        return i + "nd";
    }
    if (j == 3 && k != 13) {
        return i + "rd";
    }

    return i + "th";
  }
}
