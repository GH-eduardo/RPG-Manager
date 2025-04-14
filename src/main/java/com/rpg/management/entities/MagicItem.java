package com.rpg.management.entities;

import com.rpg.management.enums.ItemCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_magic_item")
public class MagicItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_category")
    private ItemCategory itemCategory;

    private Integer force;

    private Integer defence;

    @ManyToOne
    @JoinColumn(name = "character_id")
    private Character itemOwner;

    public MagicItem() {}

    public MagicItem(String name, ItemCategory itemCategory, Integer force, Integer defence) {
        this.name = name;
        this.itemCategory = itemCategory;
        this.force = force;
        this.defence = defence;
        this.itemOwner = null;

        if(this.itemCategory.equals(ItemCategory.WEAPON)) {
            this.defence = 0;
        }
        if(this.itemCategory.equals(ItemCategory.ARMOR)) {
            this.force = 0;
        }
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

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Integer getForce() {
        return force;
    }

    public void setDefense(Integer defence) {
        this.defence = defence;
    }

    public Integer getDefense() {
        return defence;
    }

    public void setItemOwner(Character itemOwner) {
        this.itemOwner = itemOwner;
    }

    public Character getItemOwner() {
        return itemOwner;
    }

}
