package edu.phoenixforce.scouting.mobile.exceptions;

//used for pulling TBA data (Activity config, could be expanded)

public class InvalidStateException extends RuntimeException {

    public InvalidStateException() {
    }

    public InvalidStateException(String message) {
        super(message);
    }

    public InvalidStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidStateException(Throwable cause) {
        super(cause);
    }
}
