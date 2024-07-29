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

    private String id;

    private String name;

    private Integer cost;

    private CardClass cardClass; // MAGE, DRUID, PRIEST ...

    private Integer cardSet;

    private String rule;
}