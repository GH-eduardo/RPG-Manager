package com.rpg.management.repositories;

import com.rpg.management.entities.MagicItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagicItemRepository extends JpaRepository<MagicItem, Long> {
}
