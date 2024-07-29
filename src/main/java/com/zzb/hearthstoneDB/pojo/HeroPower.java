package com.zzb.hearthstoneDB.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Class of hero powers
 *
 *
 */
@Data
@NoArgsConstructor
public class HeroPower extends Card{
    public HeroPower(String id, String name, Integer cost, CardClass cardClass, Integer cardSet, String rule) {
        super(id, name, cost, cardClass, cardSet, rule);
    }
}
