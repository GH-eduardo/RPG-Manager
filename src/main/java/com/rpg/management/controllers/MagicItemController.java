package com.rpg.management.controllers;

import com.rpg.management.dtos.CreateMagicItemDTO;
import com.rpg.management.entities.MagicItem;
import com.rpg.management.services.MagicItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "magic-items")
public class MagicItemController {
    
    @Autowired
    private MagicItemService magicItemService;

    @PostMapping
    public ResponseEntity<MagicItem> createMagicItem(@Valid @RequestBody CreateMagicItemDTO magicItemDTO) {
        return magicItemService.createMagicItem(magicItemDTO);
    }

    @GetMapping
    public ResponseEntity<List<MagicItem>> getAllMagicItems() {
        return magicItemService.getAllMagicItems();
    }

    @GetMapping(value = "search")
    public ResponseEntity<Optional<MagicItem>> getMagicItemById(@RequestParam Long id) {
        return magicItemService.getMagicItemById(id);
    }

}
