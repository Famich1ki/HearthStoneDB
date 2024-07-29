package com.zzb.hearthstoneDB.service;

import com.zzb.hearthstoneDB.dao.ImageDao;
import com.zzb.hearthstoneDB.dao.ImageDaoImp;
import com.zzb.hearthstoneDB.mapper.CardMapper;
import com.zzb.hearthstoneDB.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private final CardMapper cardMapper;

    @Autowired
    public CardService(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    // public ByteArrayResource selectCardById(String id) throws IOException{
    //     return imageDao.getImageById(id);
    // }

    // public List<Card> selectCards(Card card) {
    //     return imageDao.getImages(card);
    // }

    // Need to be modified
    // public int addCard(Card card) {
    //     int rows = 0;
    //     try {
    //         rows = imageDao.addCard();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return rows;
    // }

    public List<Card> selectMinions(String name, Integer cost, Integer attack, Integer health,
                                    String rarity, String race, String cardClass,Integer cardSet, String rule) {

        Minion minion = new Minion(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, attack,
                health, rarity == null ? null : Rarity.valueOf(rarity), race == null ? null : Race.valueOf(race), null);

        return cardMapper.selectMinion(minion);
    }

    public List<Card> selectSpells(String name, Integer cost, String rarity, String rarity1,
                                   String spellSchool, String cardClass, Integer cardSet, String rule) {

        Spell spell = new Spell(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule,
                rarity == null ? null : Rarity.valueOf(rarity), spellSchool == null ? null : SpellSchool.valueOf(spellSchool), null);

        return cardMapper.selectSpell(spell);
    }

    public List<Card> selectWeapons(String name, Integer cost, Integer attack, Integer durability,
                                    String rarity, String cardClass, Integer cardSet, String rule) {

        Weapon weapon = new Weapon(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, attack,
                        durability, rarity == null ? null : Rarity.valueOf(rarity), null);

        return cardMapper.selectWeapon(weapon);
    }

    public List<Card> selectHeroes(String name, Integer cost, Integer armor, Integer health,
                                   String rarity, String cardClass, Integer cardSet, String rule) {

        Hero hero = new Hero(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, armor,
                                 health, rarity == null ? null : Rarity.valueOf(rarity), null);

        return cardMapper.selectHero(hero);
    }

    public List<Card> selectHeroPowers(String name, Integer cost, String cardClass, String rule) {

        HeroPower heroPower = new HeroPower(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), null, rule);

        return cardMapper.selectHeroPower(heroPower);
    }

    public List<Card> selectLocations(String name, Integer cost, Integer health,
                                      String rarity, String cardClass, Integer cardSet, String rule) {

        Location location = new Location(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule,
                                        health, rarity == null ? null : Rarity.valueOf(rarity), null);

        return cardMapper.selectLocation(location);
    }

    public List<Card> selectAll(String name, Integer cost, String cardClass, Integer cardSet, String rule) {

        List<Card> results = new ArrayList<>();

        List<Card> minions= cardMapper.selectMinion(new Minion(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null, null, null));
        List<Card> spells = cardMapper.selectSpell(new Spell(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null));
        List<Card> weapons = cardMapper.selectWeapon(new Weapon(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null, null));
        List<Card> heroes = cardMapper.selectHero(new Hero(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null, null));
        List<Card> locations = cardMapper.selectLocation(new Location(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null));
        List<Card> heroPowers = cardMapper.selectHeroPower(new HeroPower(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule));

        results.addAll(minions);
        results.addAll(spells);
        results.addAll(weapons);
        results.addAll(heroes);
        results.addAll(locations);
        results.addAll(heroPowers);

        return results;
    }
}
