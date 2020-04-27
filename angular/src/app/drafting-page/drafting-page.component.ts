import { Component, OnInit } from '@angular/core';
import { Contest } from '../model/contest';
import { Player } from '../model/player';
import { Game } from '../model/game';
import { Router, ActivatedRoute } from '@angular/router';
import { ContestDetailsService } from '../service/rest/contest-details.service';
import { DraftingService } from '../service/rest/drafting.service';

@Component({
  selector: 'app-drafting-page',
  templateUrl: './drafting-page.component.html',
  styleUrls: ['./drafting-page.component.css']
})
export class DraftingPageComponent implements OnInit {

  // Symbols for seeing which item is being sorted by
  private sortSymbols = ['▲', '▼'];

  private contestId: string;
  private contest: Contest;
  private availablePlayers: Array<Player>;
  private selectedPlayers: Array<Player>;
  private countdown: string;
  private currentSalary: number;
  private apSort: string;
  private spSort: string;
  private errorMessage: string;

  constructor(private router: Router, private route: ActivatedRoute,
    private contestDetailService: ContestDetailsService,
    private draftingService: DraftingService) { }

  ngOnInit() {
    // Get the contest based on route param for contest ID
    this.route.paramMap.subscribe(params => {
      this.contestId = params.get('contestId');

      let promise = this.contestDetailService.getContestDetails(this.contestId);

      promise.then(contest => {
        let contestString = JSON.stringify(contest);
        let contestObj = Object.assign(new Contest(), JSON.parse(contestString));

        this.contest = contestObj;

        this.resetPlayers();

        // Updates every second
        // setInterval(() => { this.countdown = this.getCountdown(); }, 1000);
      });
    })
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

    let timer = [days.toString(), hours.toString(), minutes.toString(), seconds.toString()];

    /* Pad hours, minutes. seconds with 0's */
    if (hours < 10) timer[1] = '0' + timer[1];
    if (minutes < 10) timer[2] = '0' + timer[2];
    if (seconds < 10) timer[3] = '0' + timer[3];

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
    let canAdd = true;
    let error: string;

    if (this.currentSalary - player.salary < 0) {
      canAdd = false;
      error = 'Not enough money';
    }

    /* Check to see if already hired someone of that role */
    if (canAdd) {
      this.selectedPlayers.forEach(p => {
        if (p.role == player.role) {
          canAdd = false;
          error = p.role + ' player already selected';
        }
      });
    }

    if (canAdd) {
      this.availablePlayers.splice(this.availablePlayers.indexOf(player), 1);
      this.selectedPlayers.push(player);
      this.currentSalary -= player.salary;
      this.errorMessage = undefined;
      if (this.spSort != undefined) this.sort(this.spSort, false);
    } else {
      this.errorMessage = 'Could not add player: ' + error;
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
    if (this.apSort != undefined) {
      this.sort(this.apSort, false);
    }
  }

  /**
   * Resets the available players list to all available players,
   * removes all players from being selected, and resets current
   * salary back to the starting amount.
   */
  resetPlayers(): void {
    this.availablePlayers = Object.assign([], this.contest.players);
    this.selectedPlayers = new Array<Player>();
    this.currentSalary = this.contest.startingSalary;

    if (this.apSort != undefined) {
      let element = document.getElementById(this.apSort);

      let curr = element.innerHTML;
      curr = curr.slice(0, curr.length - 1);

      element.innerHTML = curr;
      this.apSort = undefined;
    }

    if (this.spSort != undefined) {
      let element = document.getElementById(this.spSort);

      let curr = element.innerHTML;
      curr = curr.slice(0, curr.length - 1);

      element.innerHTML = curr;
      this.spSort = undefined;
    }

    this.errorMessage = undefined;
  }

  /**
   * Sorts the selected column by their ID.
   * 
   * @param id - the id of the column being sorted
   * @param change - whether or not the ranking should 
   * be swapped if selected
   */
  sort(id: string, change: boolean): void {
    let element = document.getElementById(id);
    let curr = element.innerHTML;
    let i = curr.length - 1;
    let sort = !change;

    /* Currently being increasing sorted, 
    now is decreasing sorted */
    if (curr[i] == this.sortSymbols[0] && change) {
      curr = curr.slice(0, i);
      curr += this.sortSymbols[1];

      if (id[0] == 'a') this.availablePlayers.reverse();
      else this.selectedPlayers.reverse();

      sort = false;
    }

    /* Currently being decreasing sorted, 
    now is increasing sorted */
    else if (curr[i] == this.sortSymbols[1] && change) {
      curr = curr.slice(0, i);
      curr += this.sortSymbols[0];

      if (id[0] == 'a') this.availablePlayers.reverse();
      else this.selectedPlayers.reverse();

      sort = false;
    }

    /* Not currently being sorted, 
    now is increasing sort */
    else if (change) {
      /* Check to see if something is already being sorted 
      for the selected list, then unselect it */
      if (id[0] == 'a') { // Available players
        // Something else is already being sorted
        if (this.apSort != undefined) {
          // Get current value
          let v = document.getElementById(this.apSort).innerHTML;

          // Remove the sorting tag
          v = v.slice(0, v.length - 1);

          // Apply back to HTML
          document.getElementById(this.apSort).innerHTML = v;
        }

        this.apSort = id;
      } else { // Selected players
        if (this.spSort != undefined) {
          let v = document.getElementById(this.spSort).innerHTML;
          v = v.slice(0, v.length - 1);
          document.getElementById(this.spSort).innerHTML = v;
        }

        this.spSort = id;
      }

      curr += this.sortSymbols[0];
      sort = true;
    }

    if (sort) {
      /* Actually sort the elements by the desired column */
      switch (id) {
        case 'a-p-n': this.availablePlayers.sort((a, b) => a.name.localeCompare(b.name));
          break;
        case 'a-p-p': this.availablePlayers.sort((a, b) => a.role.localeCompare(b.role));
          break;
        case 'a-p-r': this.availablePlayers.sort((a, b) => a.rank - b.rank);
          break;
        case 'a-p-s': this.availablePlayers.sort((a, b) => a.salary - b.salary);
          break;
        case 's-p-n': this.selectedPlayers.sort((a, b) => a.name.localeCompare(b.name));
          break;
        case 's-p-p': this.selectedPlayers.sort((a, b) => a.role.localeCompare(b.role));
          break;
        case 's-p-r': this.selectedPlayers.sort((a, b) => a.rank - b.rank);
          break;
        case 's-p-s': this.selectedPlayers.sort((a, b) => a.salary - b.salary);
          break;
      }
    }

    element.innerHTML = curr;
  }

  /**
   * Go to the page with the rules for this selected game.
   */
  goToRules(): void {
    let baseUrl = '/rules/';
    this.router.navigateByUrl(baseUrl + this.contest.game.rulesLink);
  }

  saveLineup(): void {
    if (this.selectedPlayers.length != 5) {
      this.errorMessage = 'Please select a player of each position.';
    } else {
      let playerIdList = new Array<string>();

      // Comparator
      this.selectedPlayers.sort(function (a, b) {
        if (a.role < b.role) {
          return -1;
        } else if (a.role > b.role) {
          return 1;
        } else {
          return 0;
        }
      })
        .forEach(player => playerIdList.push(player.playerId));

      let promise = this.draftingService.draftPlayers(playerIdList, this.contestId);

      promise.then(success => {
        if (success) {
          this.router.navigateByUrl('contest/view');
        } else {
          this.errorMessage = 'something went wrong';
        }
      });

    }
  }
}
