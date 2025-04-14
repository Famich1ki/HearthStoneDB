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

    private Integer attack; // 攻击力

    private Integer health; // 生命值

    private Rarity rarity; // 稀有度

    private Race race; // 种族

    private String flavor; // 简介
}
