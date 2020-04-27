import { DateUtil } from '../util/date-util';

export class Events {
    eventId: string;
    /**
     * Name of the region/league.
     */
    name: string;

    /**
     * When the contest officially starts.
     */
    startTime: Date;

    currentState: number;

    link: string;

    /**
     * Name of the first team.
     */
    teamName: string;

    /**
     * Team code of the first team.
     */
    teamCode: string;

    /**
     * Name of the second team.
     */
    teamName2: string;

    /**
     * Team code of the second team.
     */
    teamCode2: string;

}
