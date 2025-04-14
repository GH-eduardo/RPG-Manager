package com.rpg.management.enums;

public enum CharacterClass {
    WARRIOR("Warrior"),
    MAGE("Mage"),
    ARCHER("Archer"),
    ROGUE("Rogue"),
    BARD("Bard");

    private final String name;

    CharacterClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}