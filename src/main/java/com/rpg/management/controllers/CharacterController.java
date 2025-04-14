package com.rpg.management.controllers;

import com.rpg.management.dtos.CreateCharacterDTO;
import com.rpg.management.dtos.NewAdventurerNameDTO;
import com.rpg.management.entities.Character;
import com.rpg.management.entities.MagicItem;
import com.rpg.management.services.CharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<Character> createCharacter(@Valid @RequestBody CreateCharacterDTO characterDto) {
        return characterService.createCharacter(characterDto);
    }

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping(value = "search")
    public ResponseEntity<Optional<Character>> getCharacterById(@RequestParam Long id) {
        return characterService.getCharacterById(id);
    }

    @GetMapping(value = "all-magic-items")
    public ResponseEntity<List<MagicItem>> getAllCharactersMagicItems(@RequestParam Long id) {
        return characterService.getAllCharactersMagicItems(id);
    }

    @GetMapping(value = "get-amulet")
    public ResponseEntity<MagicItem> getCharactersAmulet(@RequestParam Long id) {
        return characterService.getCharactersAmulet(id);
    }

    @PatchMapping(value = "update-adventurer-name")
    public ResponseEntity<Character> updateCharactersAdventurerNameById(@RequestParam Long id, @Valid @RequestBody NewAdventurerNameDTO updateDTO) {
        return characterService.updateCharactersAdventurerNameById(id, updateDTO);
    }

    @PatchMapping(value = "add-magic-item")
    public ResponseEntity<Character> addMagicItemToCharacter(@RequestParam Long id, @Valid @RequestBody MagicItem magicItem) {
        return characterService.addMagicItemToCharacter(id, magicItem);
    }

    @PatchMapping(value = "remove-magic-item")
    public ResponseEntity<Character> removeMagicItemFromCharacter(@RequestParam Long characterId, @Valid @RequestParam Long itemId) {
        return characterService.removeMagicItemFromCharacter(characterId, itemId);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCharacterById(@RequestParam Long id) {
        return characterService.deleteCharacterById(id);
    }
}
