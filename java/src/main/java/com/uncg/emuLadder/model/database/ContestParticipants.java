package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContestParticipants {
    @Id
    private int contestParticipantsId;

    private String userId;

    private int contestId;

    public int getContestParticipantsId() {
        return contestParticipantsId;
    }

    public void setContestParticipantsId(int contestParticipantsId) {
        this.contestParticipantsId = contestParticipantsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
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
                Objects.equals(userId, that.userId) &&
                contestId == that.contestId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestParticipantsId, userId, contestId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContestParticipants{");
        sb.append("contestParticipantsId=").append(contestParticipantsId);
        sb.append(", userId=").append(userId);
        sb.append(", contestId=").append(contestId);
        sb.append('}');
        return sb.toString();
    }
}