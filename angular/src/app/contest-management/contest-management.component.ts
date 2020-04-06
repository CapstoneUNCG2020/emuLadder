import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Player } from '../model/player';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contest-management',
  templateUrl: './contest-management.component.html',
  styleUrls: ['./contest-management.component.css']
})
export class ContestManagementComponent implements OnInit {

  contests: Array<Contest>;
  public showInviteBar: boolean;

  constructor(private router: Router) { }

  ngOnInit() {
    this.contests = new Array<Contest>();
    
    let c = new Contest();
    c.name = "Public League of Legends Tournament 1";
    c.entryFee = 20000;
    c.prizeAmount = 50000;

    let p = new Player();
    p.name = "Player 1";
    p.salary = 12000;
    p.id = 0;

    c.players.push(p);

    p = new Player();
    p.name = "Player 2";
    p.salary = 7000;
    p.id = 0;

    c.players.push(p);

    p = new Player();
    p.name = "Player 3";
    p.salary = 15000;
    p.id = 0;

    c.players.push(p);

    p = new Player();
    p.name = "Player 4";
    p.salary = 20000;
    p.id = 0;

    c.players.push(p);

    p = new Player();
    p.name = "Player 5";
    p.salary = 11000;
    p.id = 0;

    c.players.push(p);

    p = new Player();
    p.name = "Player 6";
    p.salary = 2000;
    p.id = 0;

    c.players.push(p);

    p = new Player();
    p.name = "Player 7";
    p.salary = 120000;
    p.id = 0;

    c.players.push(p);

    this.contests.push(c);
  }

  valueOf(n: number): string {
    return n.toLocaleString();
  }

  getEntryFees(): string {
    let sum = this.contests.map(x => x.entryFee).reduce((a,b) => a = b);

    return this.valueOf(sum);
  }

  editContest(contest: Contest) {
    this.router.navigateByUrl('contest/draft');
  }

  invite(): void {
    this.showInviteBar = true;
  }
}
