package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContestParticipants {
    @Id
    private int contestParticipantsId;

    private String email;

    private int contestId;

    private int points;

    public int getContestParticipantsId() {
        return contestParticipantsId;
    }

    public void setContestParticipantsId(int contestParticipantsId) {
        this.contestParticipantsId = contestParticipantsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        ContestParticipants that = (ContestParticipants) o;
        return contestParticipantsId == that.contestParticipantsId &&
                Objects.equals(email, that.email) &&
                contestId == that.contestId && points == that.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestParticipantsId, email, contestId, points);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContestParticipants{");
        sb.append("contestParticipantsId=").append(contestParticipantsId);
        sb.append(", email=").append(email);
        sb.append(", contestId=").append(contestId);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
