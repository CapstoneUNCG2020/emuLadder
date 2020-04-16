package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContestParticipants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contestParticipantsId;

    private String email;

    private int contestId;

    private int points;

    private String bottom;

    private String jungle;

    private String mid;

    private String support;

    private String top;

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

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getJungle() {
        return jungle;
    }

    public void setJungle(String jungle) {
        this.jungle = jungle;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContestParticipants)) return false;
        ContestParticipants that = (ContestParticipants) o;
        return contestParticipantsId == that.contestParticipantsId &&
                contestId == that.contestId &&
                points == that.points &&
                Objects.equals(email, that.email) &&
                Objects.equals(bottom, that.bottom) &&
                Objects.equals(jungle, that.jungle) &&
                Objects.equals(mid, that.mid) &&
                Objects.equals(support, that.support) &&
                Objects.equals(top, that.top);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestParticipantsId, email, contestId, points, bottom, jungle, mid, support, top);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContestParticipants{");
        sb.append("contestParticipantsId=").append(contestParticipantsId);
        sb.append(", email='").append(email).append('\'');
        sb.append(", contestId=").append(contestId);
        sb.append(", points=").append(points);
        sb.append(", bottom='").append(bottom).append('\'');
        sb.append(", jungle='").append(jungle).append('\'');
        sb.append(", mid='").append(mid).append('\'');
        sb.append(", support='").append(support).append('\'');
        sb.append(", top='").append(top).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
