import { DateUtil } from '../util/date-util';

export class Schedule {
    /**
     * Code representing the first team in the event
     */ 
    teamCode1: string;

    /**
     * Code representing the second team in the event
     */ 
    teamCode2: string;

    /**
     * When the game is shceduled to start
     */
    startTime: Date;
    
    /**
     * When the game is shceduled to start
     */
    slateTime: string;

    /**
     * The region in which the game is to be played
     */
    region: string;

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
        let dayOfWeek = isNaN(day) ? null : ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][day];

        return dayOfWeek + ' ' + time;
    }
}
