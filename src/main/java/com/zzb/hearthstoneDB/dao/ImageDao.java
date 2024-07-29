package com.zzb.hearthstoneDB.dao;

import com.zzb.hearthstoneDB.pojo.Card;
import org.springframework.core.io.ByteArrayResource;

import java.io.IOException;
import java.util.List;

public interface ImageDao {

   List<Card> getImages(Card card);

   ByteArrayResource getImageById(String id) throws IOException;

   int addCard();
}
