package com.uncg.emuLadder.model.response;

import java.util.List;
import java.util.Objects;

public class RegisteredContestsData {
    private List<RegisteredContest> registeredContests;

    public List<RegisteredContest> getRegisteredContests() {
        return registeredContests;
    }

    public void setRegisteredContests(List<RegisteredContest> registeredContests) {
        this.registeredContests = registeredContests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredContestsData)) return false;
        RegisteredContestsData that = (RegisteredContestsData) o;
        return Objects.equals(registeredContests, that.registeredContests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registeredContests);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisteredContestsData{");
        sb.append("registeredContests=").append(registeredContests);
        sb.append('}');
        return sb.toString();
    }
}
