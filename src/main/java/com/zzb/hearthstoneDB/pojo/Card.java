package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Basic class for all cards.
 * Containing all the basic attributes of card.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private String id; // 每张卡牌的唯一id

    private String name; // 卡牌名称

    private Integer cost; // 卡牌费用

    private CardClass cardClass; // MAGE, DRUID, PRIEST ...

    private Integer cardSet; // 一个整数，对应着一个版本

    private String rule; // 卡牌描述
}