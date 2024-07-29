package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Class of heroes
 *
 *
 */
@Data
@NoArgsConstructor
public class Hero extends Card{
    public Hero(String id, String name, Integer cost, CardClass cardClass, Integer cardSet,
                String rule, Integer armor, Integer health, Rarity rarity, String flavor) {
        super(id, name, cost, cardClass, cardSet, rule);
        this.armor = armor;
        this.health = health;
        this.rarity = rarity;
        this.flavor = flavor;
    }

    private Integer armor;

    private Integer health;

    private Rarity rarity;

    private String flavor;
}
