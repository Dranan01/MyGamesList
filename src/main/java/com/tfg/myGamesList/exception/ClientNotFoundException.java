package com.tfg.myGamesList.exception;

/**
 * Excepción de producto no encontrado
 * @author Santiago Faci
 * @version Curso 2020-2021
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
