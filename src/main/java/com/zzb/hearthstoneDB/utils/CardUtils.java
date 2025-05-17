package com.zzb.hearthstoneDB.utils;

import com.zzb.hearthstoneDB.pojo.Card;

import java.util.*;

/*



 */
public class CardUtils {
    public static Comparator<Card> SORT_BY_COST() {
        return Comparator.comparing(Card::getCost)
                            .thenComparing(Card::getName);
    }

    public static Comparator<Card> SORT_BY_NAME() {
        return new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                int result = c1.getName().compareTo(c2.getName());
                if(result != 0) {
                    return result;
                }
                return Integer.compare(c1.getCost(), c2.getCost());
            }
        };
    }

}
