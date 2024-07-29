package com.zzb.hearthstoneDB.mapper;

import com.zzb.hearthstoneDB.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;

@Mapper
public interface CardMapper {

    // int addCard(@Param("card") Card card);

    List<Card> selectCards(@Param("card_query") Card card);

    String selectCardById(String id);

    List<Card> selectMinion(@Param("minion") Minion minion);

    List<Card> selectSpell(@Param("spell") Spell spell);

    List<Card> selectWeapon(@Param("weapon") Weapon weapon);

    List<Card> selectHero(@Param("hero") Hero hero);

    List<Card> selectHeroPower(@Param("heroPower") HeroPower heroPower);

    List<Card> selectLocation(@Param("location") Location location);
}
