INSERT INTO tb_character(id, name, adventurer_name, character_class, level, force, defence) VALUES (0, 'Pedro, o Primeiro', 'Dom Pedro', 'WARRIOR', 0, 5, 5);
INSERT INTO tb_character(id, name, adventurer_name, character_class, level, force, defence) VALUES (1, 'Pedro, o Segundo', 'Dom Pedro II', 'MAGE', 0, 8, 2);
INSERT INTO tb_character(id, name, adventurer_name, character_class, level, force, defence) VALUES (2, 'Apolo', 'Apolo', 'ARCHER', 0, 6, 4);
INSERT INTO tb_character(id, name, adventurer_name, character_class, level, force, defence) VALUES (3, 'Henry Walton Jones Jr', 'Indiana Jones', 'ROGUE', 0, 9, 1);
INSERT INTO tb_character(id, name, adventurer_name, character_class, level, force, defence) VALUES (4, 'Orfeu', 'Orfeu', 'BARD', 0, 3, 7);

INSERT INTO tb_magic_item(id, name, item_category, force, defence, character_id) VALUES (0, 'Sword', 'WEAPON', 7, 0, null);
INSERT INTO tb_magic_item(id, name, item_category, force, defence, character_id) VALUES (1, 'Steel Armor', 'ARMOR', 0, 6, null);
INSERT INTO tb_magic_item(id, name, item_category, force, defence, character_id) VALUES (2, 'Holy Grail', 'AMULET', 10, 10, null);

ALTER TABLE tb_character ALTER COLUMN id RESTART WITH 5;
ALTER TABLE tb_magic_item ALTER COLUMN id RESTART WITH 3;