import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Player } from '../model/player';
import { Game } from '../model/game';

@Component({
  selector: 'app-drafting-page',
  templateUrl: './drafting-page.component.html',
  styleUrls: ['./drafting-page.component.css']
})
export class DraftingPageComponent implements OnInit {

  private contest: Contest;
  private availablePlayers: Array<Player>;
  private selectedPlayers: Array<Player>;
  private countdown: string;
  private currentSalary: number;

  constructor() { }

  ngOnInit() {
    this.contest = this.testContest();
    this.resetPlayers();

    // Updates every second
    setInterval(() => {this.countdown = this.getCountdown();}, 1000);
  }

  private testContest(): Contest {
    let contest = new Contest();

    contest = new Contest();
    contest.name = 'Public League of Legends Tournament 1';
    contest.currentEntries = 0;
    contest.maxEntries = 2;
    contest.type = 'Head-to-Head';
    contest.entryFee = 0;
    contest.prizeAmount = 0;
    contest.startingSalary = 40000;
    
    let time = new Date();
    time.setHours(12);
    time.setMinutes(0);
    time.setSeconds(0);
    time.setMilliseconds(0);
    time.setMonth(3);
    time.setDate(1);
    time.setFullYear(2020);

    contest.startTime = time;

    let game = new Game();
    game.name = 'League of Legends';
    game.rulesLink = 'leagueOfLegends';

    contest.game = game;

    contest.players = this.testPlayers();

    return contest;
  }

  private testPlayers(): Array<Player> {
    let players = new Array<Player>();

    let player = new Player();
    player.name = 'Player 1';
    player.position = 'Mid';
    player.rank = 2;
    player.salary = 17000;

    players.push(player);

    player = new Player();
    player.name = 'Player 2';
    player.position = 'Front';
    player.rank = 3;
    player.salary = 15000;

    players.push(player);

    player = new Player();
    player.name = 'Player 3';
    player.position = 'Back';
    player.rank = 1;
    player.salary = 20000;

    players.push(player);

    return players;
  }

  /**
   * Gets the countdown until the contest starts
   */
  getCountdown(): string {
    // Get milliseconds until contest starts
    let ms = this.contest.startTime.getTime() - new Date().getTime();
    
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

    let timer = [days, hours, minutes, seconds];

    return timer.join(':');
  }

  /**
   * Adds a player to the selected players list and removes them
   * from being able to be selected, as well as removing their salary 
   * amount from current salary.
   * 
   * @param player - the player being selected
   */
  addPlayer(player: Player): void {
    if (this.currentSalary - player.salary >= 0) {
      this.availablePlayers.splice(this.availablePlayers.indexOf(player), 1);
      this.selectedPlayers.push(player);

      this.currentSalary -= player.salary;
    } else {
      // TODO: Add error message
      console.log('not enough money');
    }
  }

  /**
   * Removes a player from the selected players list and returns their 
   * availability and their salary back to the user. 
   * 
   * @param player - the player being selected
   */
  removePlayer(player: Player): void {
    this.selectedPlayers.splice(this.selectedPlayers.indexOf(player), 1);
    this.availablePlayers.push(player);

    this.currentSalary += player.salary;
  }

  /**
   * Resets the available players list to all available players,
   * removes all players from being selected, and resets current
   * salary back to the starting amount.
   */
  resetPlayers() {
    this.availablePlayers = Object.assign([], this.contest.players);
    this.selectedPlayers = new Array<Player>();
    this.currentSalary = this.contest.startingSalary;
  }
}
