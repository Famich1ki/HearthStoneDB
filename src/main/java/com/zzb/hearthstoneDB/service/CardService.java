package com.zzb.hearthstoneDB.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzb.hearthstoneDB.dao.ImageDao;
import com.zzb.hearthstoneDB.dao.ImageDaoImp;
import com.zzb.hearthstoneDB.mapper.CardMapper;
import com.zzb.hearthstoneDB.pojo.*;
import com.zzb.hearthstoneDB.utils.CardUtils;
import com.zzb.hearthstoneDB.utils.PageResponse;
import com.zzb.hearthstoneDB.utils.PageUtils;
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

    public PageResponse<Card> selectMinions(String name, Integer cost, Integer attack, Integer health,
                                    String rarity, String race, String cardClass, Integer cardSet, String rule, Integer pageNum, Integer pageSize) {

        Minion minion = new Minion(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, attack,
                health, rarity == null ? null : Rarity.valueOf(rarity), race == null ? null : Race.valueOf(race), null);


        return PageUtils.getPage(pageNum, pageSize, () -> cardMapper.selectMinion(minion));
    }

    public PageResponse<Card> selectSpells(String name, Integer cost, String rarity, String rarity1,
                                   String spellSchool, String cardClass, Integer cardSet, String rule, Integer pageNum, Integer pageSize) {

        Spell spell = new Spell(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule,
                rarity == null ? null : Rarity.valueOf(rarity), spellSchool == null ? null : SpellSchool.valueOf(spellSchool), null);

        return PageUtils.getPage(pageNum, pageSize, () -> cardMapper.selectSpell(spell));
    }

    public PageResponse<Card> selectWeapons(String name, Integer cost, Integer attack, Integer durability,
                                    String rarity, String cardClass, Integer cardSet, String rule, Integer pageNum, Integer pageSize) {

        Weapon weapon = new Weapon(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, attack,
                        durability, rarity == null ? null : Rarity.valueOf(rarity), null);

        return PageUtils.getPage(pageNum, pageSize, () -> cardMapper.selectWeapon(weapon));
    }

    public PageResponse<Card> selectHeroes(String name, Integer cost, Integer armor, Integer health,
                                   String rarity, String cardClass, Integer cardSet, String rule, Integer pageNum, Integer pageSize) {

        Hero hero = new Hero(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, armor,
                                 health, rarity == null ? null : Rarity.valueOf(rarity), null);

        return PageUtils.getPage(pageNum, pageSize, () -> cardMapper.selectHero(hero));
    }

    public PageResponse<Card> selectHeroPowers(String name, Integer cost, String cardClass, String rule, Integer pageNum, Integer pageSize) {

        HeroPower heroPower = new HeroPower(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), null, rule);

        return PageUtils.getPage(pageNum, pageSize, () -> cardMapper.selectHeroPower(heroPower));
    }

    public PageResponse<Card> selectLocations(String name, Integer cost, Integer health,
                                      String rarity, String cardClass, Integer cardSet, String rule, Integer pageNum, Integer pageSize) {

        Location location = new Location(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule,
                                        health, rarity == null ? null : Rarity.valueOf(rarity), null);

        return PageUtils.getPage(pageNum, pageSize, () -> cardMapper.selectLocation(location));
    }

    // public PageResponse<Card> selectAll(String name, Integer cost, String cardClass, Integer cardSet, String rule, Integer pageNum, Integer pageSize) {
    //
    //     List<Card> cardInfo = new ArrayList<>();
    //
    //     List<Card> minions= cardMapper.selectMinion(new Minion(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null, null, null));
    //     List<Card> spells = cardMapper.selectSpell(new Spell(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null));
    //     List<Card> weapons = cardMapper.selectWeapon(new Weapon(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null, null));
    //     List<Card> heroes = cardMapper.selectHero(new Hero(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null, null));
    //     List<Card> locations = cardMapper.selectLocation(new Location(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule, null, null, null));
    //     List<Card> heroPowers = cardMapper.selectHeroPower(new HeroPower(null, name, cost, cardClass == null ? null : CardClass.valueOf(cardClass), cardSet, rule));
    //
    //     cardInfo.addAll(minions);
    //     cardInfo.addAll(spells);
    //     cardInfo.addAll(weapons);
    //     cardInfo.addAll(heroes);
    //     cardInfo.addAll(locations);
    //     cardInfo.addAll(heroPowers);
    //
    //     cardInfo.sort(CardUtils.SORT_BY_COST());
    //     return getPage(pageNum, pageSize, cardInfo);
    // }


}
