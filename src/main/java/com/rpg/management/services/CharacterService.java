package com.rpg.management.services;

import com.rpg.management.dtos.CreateCharacterDTO;
import com.rpg.management.dtos.NewAdventurerNameDTO;
import com.rpg.management.entities.Character;
import com.rpg.management.entities.MagicItem;
import com.rpg.management.enums.ItemCategory;
import com.rpg.management.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public ResponseEntity<Character> createCharacter(CreateCharacterDTO characterDto) {
        Character newCharacter = new Character(characterDto.getName(), characterDto.getAdventurerName(), characterDto.getCharacterClass(), characterDto.getForce(), characterDto.getDefence());
        Character savedCharacter = characterRepository.save(newCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
    }

    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> allCharacters = characterRepository.findAll();
        return ResponseEntity.ok(allCharacters);
    }

    public ResponseEntity<Optional<Character>> getCharacterById(Long id) {
        Optional<Character> character = characterRepository.findById(id);
        return ResponseEntity.ok(character);
    }

    public ResponseEntity<List<MagicItem>> getAllCharactersMagicItems(Long id) {
        Optional<Character> characterOpt = characterRepository.findById(id);

        if(characterOpt.isPresent()) {
            Character character = characterOpt.get();
            List<MagicItem> magicItems = character.getMagicItems();
            return ResponseEntity.ok(magicItems);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public MagicItem findAmulet(Long id) {
        Optional<Character> characterOpt = characterRepository.findById(id);

        if(characterOpt.isPresent()) {
            Character character = characterOpt.get();
            List<MagicItem> magicItems = character.getMagicItems();
            MagicItem amulet;
            for (MagicItem item : magicItems) {
                if (item.getItemCategory().equals(ItemCategory.AMULET)) {
                    amulet = item;
                    return amulet;
                }
            }
        }
        return null;
    }

    public ResponseEntity<MagicItem> getCharactersAmulet(Long id) {
        MagicItem amulet = findAmulet(id);
        if(amulet != null) {
            return ResponseEntity.ok(amulet);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    public ResponseEntity<Character> updateCharactersAdventurerNameById(Long id, NewAdventurerNameDTO updateDTO) {
        return characterRepository.findById(id).map(character -> {
            character.setAdventurerName(updateDTO.getAdventurerName());
            Character updatedCharacter = characterRepository.save(character);
            return ResponseEntity.ok(updatedCharacter);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    public ResponseEntity<Character> addMagicItemToCharacter(Long id, MagicItem magicItem) {
        if(findAmulet(id) != null) {
            return characterRepository.findById(id).map(character -> {
                magicItem.setItemOwner(character);
                character.getMagicItems().add(magicItem);
                character.setForce(character.getForce() + magicItem.getForce());
                character.setDefence(character.getDefence() + magicItem.getDefense());
                Character updatedCharacter = characterRepository.save(character);
                return ResponseEntity.ok(updatedCharacter);
            }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        } else {
            throw new RuntimeException("Only one amulet is allowed per Character!");
        }
    }

    public ResponseEntity<Character> removeMagicItemFromCharacter(Long characterId, Long itemId) {
        return characterRepository.findById(characterId).map(character -> {
            MagicItem itemToRemove = null;
            for (MagicItem item : character.getMagicItems()) {
                if (item.getId().equals(itemId)) {
                    itemToRemove = item;
                    break;
                }
            }
            if (itemToRemove != null) {
                character.getMagicItems().remove(itemToRemove);
                Character updatedCharacter = characterRepository.save(character);
                return ResponseEntity.ok(updatedCharacter);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(character);
            }
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    public ResponseEntity<?> deleteCharacterById(Long id) {
        characterRepository.deleteById(id);
        return ResponseEntity.ok("character deleted with success!");
    }
}
