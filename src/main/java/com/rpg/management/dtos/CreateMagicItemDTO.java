package com.rpg.management.dtos;

import com.rpg.management.enums.ItemCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMagicItemDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "item_category")
    private ItemCategory itemCategory;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer force;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer defence;

    public CreateMagicItemDTO(String name, ItemCategory itemCategory, Integer force, Integer defence) {
        this.name = name;
        this.itemCategory = itemCategory;
        this.force = force;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public Integer getForce() {
        return force;
    }

    public void setForce(Integer force) {
        this.force = force;
    }

    public Integer getDefense() {
        return defence;
    }

    public void setDefense(Integer defence) {
        this.defence = defence;
    }
}
