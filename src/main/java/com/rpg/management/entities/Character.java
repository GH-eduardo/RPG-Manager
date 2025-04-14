package com.rpg.management.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rpg.management.enums.CharacterClass;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "tb_character")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String adventurerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "character_class")
    private CharacterClass characterClass;

    private Integer level;

    @OneToMany(mappedBy = "itemOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MagicItem> magicItems;

    private Integer force;

    private Integer defence;

    public Character () {}

    public Character(String name, String adventurerName, CharacterClass characterClass, Integer force, Integer defence) {
        this.name = name;
        this.adventurerName = adventurerName;
        this.characterClass = characterClass;
        this.level = 0;
        this.magicItems = new ArrayList<>();
        this.force = force;
        this.defence = defence;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAdventurerName(String adventurerName) {
        this.adventurerName = adventurerName;
    }

    public String getAdventurerName() {
        return adventurerName;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setMagicItems(List<MagicItem> magicItems) {
        this.magicItems = magicItems;
    }

    public List<MagicItem> getMagicItems() {
        return magicItems;
    }

    public void setForce(Integer force) {
        this.force = force;
    }
    public Integer getForce() {
        return force;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getDefence() {
        return defence;
    }
}
