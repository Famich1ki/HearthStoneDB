package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class of minion
 *
 *
 */
@Data
@NoArgsConstructor
public class Minion extends Card{
    public Minion(String id, String name, Integer cost, CardClass cardClass, Integer cardSet,
                  String rule, Integer attack, Integer health, Rarity rarity, Race race, String flavor) {
        super(id, name, cost, cardClass, cardSet, rule);
        this.attack = attack;
        this.health = health;
        this.rarity = rarity;
        this.race = race;
        this.flavor = flavor;
    }

    private Integer attack;

    private Integer health;

    private Rarity rarity;

    private Race race;

    private String flavor;
}
