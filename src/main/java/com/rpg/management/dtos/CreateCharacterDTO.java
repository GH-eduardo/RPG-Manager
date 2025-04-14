package com.rpg.management.dtos;

import com.rpg.management.enums.CharacterClass;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.bind.DefaultValue;

public class CreateCharacterDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String adventurerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClass characterClass;

    @NotNull
    @Min(0)
    @Max(10)
    @Schema(defaultValue = "5")
    private Integer force;

    @NotNull
    @Min(0)
    @Max(10)
    @Schema(defaultValue = "5")
    private Integer defence;

    public CreateCharacterDTO(String name, String adventurerName, CharacterClass characterClass, Integer force, Integer defence) {

        if( (defence + force) != 10) {
            throw new IllegalArgumentException("The sum of strength and defence must be exactly 10");
        }

        this.name = name;
        this.adventurerName = adventurerName;
        this.characterClass = characterClass;
        this.force = force;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdventurerName() {
        return adventurerName;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }
}
