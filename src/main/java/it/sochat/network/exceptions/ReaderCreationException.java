package it.sochat.network.exceptions;

import it.sochat.Main;

public class ReaderCreationException extends RuntimeException {

    public ReaderCreationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ReaderCreationException(String errorMessage) {
        super(errorMessage);
    }

}
