/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tfg.myGamesList.model.domain;

import com.tfg.myGamesList.model.Achievement;
import com.tfg.myGamesList.model.Game;
import java.util.ArrayList;
import java.util.List;
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
public class AchievementList {
    private String gameName;
    private List<AchievementResume> achievements;

    public AchievementList(Game game) {
        achievements = new ArrayList();
        this.gameName = game.getName();
        List<Achievement> achievementsRes = game.getAchievements();
        for (Achievement achievement : achievementsRes) {
            AchievementResume achievementResume = new AchievementResume(achievement);
            this.achievements.add(achievementResume);

        }
    }
}
