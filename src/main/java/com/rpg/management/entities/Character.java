package com.rpg.management.entities;

import java.util.List;

public class Character {

    private Long id;
    private String name;
    private String adventurerName;
    private String characterClass;
    private Number level;
    private List<MagicItem> magicItems;
    private Number strength;
    private Number defence;

    public Character () {}
}
