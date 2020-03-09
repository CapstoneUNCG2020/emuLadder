import { Game } from './game';
import { Player } from './player';
import { DateUtil } from '../util/date-util';

export class Contest {
    /**
     * Name of the contest.
     */
    name: string;

    /**
     * Type of Contest: Multiplayer or Head-to-Head.
     */
    type: string;

    /**
     * Maximum number of users who can sign up for
     * this contest.
     */
    maxEntries: number;

    /**
     * Current number of users who have signed up for this contest.
     */
    currentEntries: number;

    /**
     * The price to enter this contest.
     */
    entryFee: number;

    /**
     * The amount of the prize that will be received if the user wins.
     */
    prizeAmount: number;

    /**
     * When the contest officially starts.
     */
    startTime: Date;

    /**
     * The game that the contest is covering.
     */
    game: Game;

    /**
     * The amount of money each user has to spend while drafting.
     */
    startingSalary: number;

    /**
     * The players that are participating in this contest.
     */
    players: Array<Player>;

    constructor() {
        this.players = new Array<Player>();
    }

    /**
     * Displays the start time in a user friendly format:
     * { DayofWeek, Month Date at LocalTime }
     */
    public getStartTime(): string {
        let t = this.startTime;
        let day = t.getDay();
        let month = t.getMonth();
        let date = t.getDate();
        let time = t.toLocaleTimeString();

        return DateUtil.DAYS[day] + ', ' + DateUtil.MONTHS[month] + ' ' + date + ' at ' + time;   
    }
}