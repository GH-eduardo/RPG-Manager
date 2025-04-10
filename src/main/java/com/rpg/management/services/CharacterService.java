package com.rpg.management.services;

import com.rpg.management.entities.Character;
import com.rpg.management.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character newCharacter = characterRepository.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCharacter);
    }

    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> allCharacters = characterRepository.findAll();
        return ResponseEntity.ok(allCharacters);
    }

    public ResponseEntity<Optional<Character>> getCharacterById(@RequestParam Long id) {
        Optional<Character> character = characterRepository.findById(id);
        return ResponseEntity.ok(character);
    }

    public ResponseEntity<Character> updateCharacterById(@RequestParam Long id, @RequestBody Character updateCharacter) {
        return characterRepository.findById(id).map( character -> {
            character.setName(updateCharacter.getName());

            Character updatedCharacter = characterRepository.save(character);
            return ResponseEntity.ok(updatedCharacter);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }

    public ResponseEntity<?> deleteCharacterById(@RequestParam Long id) {
        characterRepository.deleteById(id);
        return ResponseEntity.ok("personagem deletado com sucesso!");
    }
}
