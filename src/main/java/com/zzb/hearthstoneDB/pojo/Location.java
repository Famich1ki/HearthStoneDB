package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location extends Card{
    public Location(String id, String name, Integer cost, CardClass cardClass,
                    Integer cardSet, String rule, Integer health, Rarity rarity, String flavor) {
        super(id, name, cost, cardClass, cardSet, rule);
        this.health = health;
        this.rarity = rarity;
        this.flavor = flavor;
    }

    private Integer health;

    private Rarity rarity;

    private String flavor;
}
