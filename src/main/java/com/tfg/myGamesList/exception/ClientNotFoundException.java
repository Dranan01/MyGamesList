package com.tfg.myGamesList.exception;

/**
 * 
 * @author Francisco Miguel Pérez
 * 
 */
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super();
    }

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(long id) {
        super("Client not found: " + id);
    }
}
