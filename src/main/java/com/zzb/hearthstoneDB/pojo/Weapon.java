package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Class of weapons
 *
 *
 */
@Data
@NoArgsConstructor
public class Weapon extends Card{
    public Weapon(String id, String name, Integer cost, CardClass cardClass, Integer cardSet,
                  String rule, Integer attack, Integer durability, Rarity rarity, String flavor) {
        super(id, name, cost, cardClass, cardSet, rule);
        this.attack = attack;
        this.durability = durability;
        this.rarity = rarity;
        this.flavor = flavor;
    }

    private Integer attack;

    private Integer durability;

    private Rarity rarity;

    private String flavor;
}
