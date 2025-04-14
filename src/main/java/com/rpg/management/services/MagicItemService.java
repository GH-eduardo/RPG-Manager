package com.rpg.management.services;

import com.rpg.management.dtos.CreateMagicItemDTO;
import com.rpg.management.entities.MagicItem;
import com.rpg.management.repositories.MagicItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagicItemService {
    
    @Autowired
    private MagicItemRepository magicItemRepository;

    public ResponseEntity<?> createMagicItem(CreateMagicItemDTO magicItemDTO) {
        MagicItem newMagicItem = new MagicItem(magicItemDTO.getName(), magicItemDTO.getItemCategory(), magicItemDTO.getForce(), magicItemDTO.getDefense());
        if(magicItemDTO.getDefense() == 0 && magicItemDTO.getForce() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A magicItem must not have 0 force and 0 defence at the same time!");
        }
        magicItemRepository.save(newMagicItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMagicItem);
    }

    public ResponseEntity<List<MagicItem>> getAllMagicItems() {
        List<MagicItem> allMagicItems = magicItemRepository.findAll();
        return ResponseEntity.ok(allMagicItems);
    }

    public ResponseEntity<Optional<MagicItem>> getMagicItemById(Long id) {
        Optional<MagicItem> magicItem = magicItemRepository.findById(id);
        return ResponseEntity.ok(magicItem);
    }

}
