import { Game } from './game';
import { WeekDay } from '@angular/common';

export class Contest {
    name: string;
    type: string;
    maxEntries: number;
    currentEntries: number;
    entryFee: number;
    prizeAmount: number;
    startTime: Date;
    game: Game;

    private static DAYS = ['Sun', 'Mon', 'Tue', 'Wed', 'Thurs', 'Fri', 'Sat'];
    private static MONTHS = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

    public getStartTime(): string {
        let t = this.startTime;
        let day = t.getDay();
        let month = t.getMonth();
        let date = t.getDate();
        let time = t.toLocaleTimeString();

        return Contest.DAYS[day] + ', ' + Contest.MONTHS[month] + ' ' + date + ' at ' + time;   
    }
}