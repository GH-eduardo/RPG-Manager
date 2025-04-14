package com.rpg.management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewAdventurerNameDTO {

    @NotNull
    @NotBlank(message = "Adventurer name is mandatory")
    private String newAdventurerName;
    
    public NewAdventurerNameDTO() {
    }

    public NewAdventurerNameDTO(String newAdventurerName) {
        this.newAdventurerName = newAdventurerName;
    }
    
    public String getAdventurerName() {
        return newAdventurerName;
    }

    public void setAdventurerName(String newAdventurerName) {
        this.newAdventurerName = newAdventurerName;
    }
}