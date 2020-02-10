package com.uncg.emuLadder.model.response;

import java.util.Objects;

public class SignUpResponseData {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

        SignUpResponseData that = (SignUpResponseData) o;
        return success == that.success;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SignUpResponseData{");
        sb.append("success=").append(success);
        sb.append('}');
        return sb.toString();
    }
}
