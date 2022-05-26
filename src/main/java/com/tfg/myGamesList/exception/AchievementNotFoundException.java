/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.exception;

/**
 *
 * @author Francisco Miguel Pérez
 */
public class AchievementNotFoundException extends RuntimeException{
    public AchievementNotFoundException() {
        super();
    }

    public AchievementNotFoundException(String message) {
        super(message);
    }

    public AchievementNotFoundException(long id) {
        super("Achievement not found: " + id);
    }
}
