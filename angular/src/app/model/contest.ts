import { Game } from './game';
import { Player } from './player';
import { Schedule } from './schedule';
import { DateUtil } from '../util/date-util';

export class Contest {

    /**
     * Unique ID for the contest
     */
    contestId: number

    /**
     * Name of the contest.
     */
    name: string;

    /**
     * Type of Contest: Multiplayer or Head-to-Head.
     */
    contestType: number;

    /**
     * Maximum number of users who can sign up for
     * this contest.
     */
    totalSpaces: number;

    /**
     * Current number of users who have signed up for this contest.
     */
    remainingSpaces: number;

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

    /**
     * 
     */
    schedules: Array<Schedule>;

    constructor() {
        this.players = new Array<Player>();
        this.schedules = new Array<Schedule>();
        this.startingSalary = 25000;
    }

    /**
     * Displays the start time in a user friendly format:
     * { DayofWeek, Month Date at LocalTime }
     */
    public getStartTime(): string {
        let t = new Date(this.startTime);

        let day = t.getDay();
        let month = t.getMonth();
        let date = t.getDate();
        let time = t.toLocaleTimeString();

        return DateUtil.DAYS[day] + ', ' + DateUtil.MONTHS[month] + ' ' + date + ' at ' + time;   
    }

    public getContestType(): string {
        switch (this.contestType) {
            case 0: return 'Head-to-Head';
            case 1: return 'Public';
            case 2: return 'Private';
        }
    }
}