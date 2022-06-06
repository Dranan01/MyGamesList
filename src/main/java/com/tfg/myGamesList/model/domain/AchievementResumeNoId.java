/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Francisco Miguel Pérez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementResumeNoId {
        @Schema(description = "a short description of the achievement", example = "Survive a solar eclipse, a day darker than night filled with creatures of horror.", required = true)
    private String achDescription;
    
    @Schema(description = "the location of the image of the achievement", example = "c:/games/game/{gameName}/achievement/1", required = true)
    private String achImage;

    @Schema(description = "An indicator to know if the achievement is completed or not", example = "true", required = true)
    private boolean isDone;
    
    @Schema(description = "The difficult to obtain the achievemnt", example = "easy", required = true)
    private String difficulty;
}
