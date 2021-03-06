/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response {

    public static final int NO_ERROR = 0;
    public static final int NOT_FOUND = 101;

    public static final String NO_MESSAGE = "";

    private Error error;

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class Error {
        private long errorCode;
        private String message;
    }

    public static Response noErrorResponse() {
        return new Response(new Error(NO_ERROR, NO_MESSAGE));
    }

    public static Response errorResonse(int errorCode, String errorMessage) {
        return new Response(new Error(errorCode, errorMessage));
    }
    
        public static Response errorResonse(int errorCode, String errorMessage, String moreInfo) {
        return new Response(new Error(errorCode, errorMessage+" "+ moreInfo));
    }
}