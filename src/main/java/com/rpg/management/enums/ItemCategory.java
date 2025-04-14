package com.rpg.management.enums;

public enum ItemCategory {

    WEAPON("Weapon"),
    ARMOR("Armor"),
    AMULET("Amulet");

    private final String name;

    ItemCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
