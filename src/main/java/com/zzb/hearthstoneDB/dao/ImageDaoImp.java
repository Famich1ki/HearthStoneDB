package com.zzb.hearthstoneDB.dao;

import com.zzb.hearthstoneDB.mapper.CardMapper;
import com.zzb.hearthstoneDB.pojo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Repository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ImageDaoImp implements ImageDao{

    private final CardMapper cardMapper;

    @Autowired
    public ImageDaoImp(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }

    @Override
    public List<Card> getImages(Card card) {
        return cardMapper.selectCards(card);
    }

    @Override
    public ByteArrayResource getImageById(String id) throws IOException {
        String img_path = cardMapper.selectCardById(id);

        // 先把图片转换成byte数组
        BufferedImage image = ImageIO.read(new File(img_path));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] imageBytes = baos.toByteArray();

        // 把byte数组转换成可以响应给前端的资源
        return new ByteArrayResource(imageBytes);
    }

    @Override
    public int addCard() {
        return 0;
    }


}
