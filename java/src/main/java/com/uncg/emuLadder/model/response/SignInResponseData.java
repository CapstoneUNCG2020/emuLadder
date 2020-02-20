package com.uncg.emuLadder.model.response;

import java.util.Objects;

public class SignInResponseData {
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

        SignInResponseData that = (SignInResponseData) o;
        return success == that.success;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SignInResponseData{");
        sb.append("success=").append(success);
        sb.append('}');
        return sb.toString();
    }
}