package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Class of spells
 *
 *
 */
@Data
@NoArgsConstructor
public class Spell extends Card{
    public Spell(String id, String name, Integer cost, CardClass cardClass, Integer cardSet,
                 String rule, Rarity rarity, SpellSchool spellSchool, String flavor) {
        super(id, name, cost, cardClass, cardSet, rule);
        this.rarity = rarity;
        this.spellSchool = spellSchool;
        this.flavor = flavor;
    }

    private Rarity rarity;

    private SpellSchool spellSchool; // FIRE, FROST, ARCANE ...

    private String flavor;
}
