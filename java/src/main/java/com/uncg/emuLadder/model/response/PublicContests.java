package com.uncg.emuLadder.model.response;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class PublicContests {
    private List<Contest> contests;

    public List<Contest> getContests() {
        return contests;
    }

    public void setContests(List<Contest> contests) {
        this.contests = contests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicContests that = (PublicContests) o;
        return Objects.equals(contests, that.contests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contests);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PublicContests{");
        sb.append("contests=").append(contests);
        sb.append('}');
        return sb.toString();
    }
}