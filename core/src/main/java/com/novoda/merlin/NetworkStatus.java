package com.novoda.merlin;

public class NetworkStatus {

    private final State state;

    private NetworkStatus(State state) {
        this.state = state;
    }

    public static NetworkStatus newAvailableInstance() {
        return new NetworkStatus(State.AVAILABLE);
    }

    public static NetworkStatus newUnavailableInstance() {
        return new NetworkStatus(State.UNAVAILABLE);
    }

    public boolean isAvailable() {
        return state.equals(State.AVAILABLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NetworkStatus that = (NetworkStatus) o;
        return state == that.state;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }

    private enum State {
        AVAILABLE,
        UNAVAILABLE
    }

}
