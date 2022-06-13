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
@NoArgsConstructor
public class AchievementList {
    private List<AchievementResume> achievements;

    public AchievementList(List<Achievement> ach){
        ArrayList<AchievementResume> temp = new ArrayList();
        for (Achievement achievement:ach) {
            
            AchievementResume resume = new AchievementResume(achievement);
            temp.add(resume);
                    
        }
        
        this.achievements = temp;
        
    }
   
   
    
    
    
}
