package com.zzb.hearthstoneDB.controller;

import com.zzb.hearthstoneDB.pojo.Card;
import com.zzb.hearthstoneDB.service.CardService;
import com.zzb.hearthstoneDB.utils.CardUtils;
import com.zzb.hearthstoneDB.utils.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cards/api")
@CrossOrigin
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    
    // @PostMapping
    // public int addCard(@RequestBody Card card) {
    //     return cardService.addCard(card);
    // }
    
    // @GetMapping
    // public ResponseEntity<Resource> selectCardById(@RequestParam("id") String id) {
    //     try {
    //         ByteArrayResource resource = cardService.selectCardById(id);
    //         // 设置响应头
    //         HttpHeaders headers = new HttpHeaders();
    //         headers.add(HttpHeaders.CONTENT_TYPE, "image/jpg");
    //
    //         return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }
    // @PostMapping
    // public List<Card> selectCards(@RequestBody Card card) {
    //     System.out.println(card);
    //     return cardService.selectCards(card);
    // }

    @GetMapping("/minion")
    public PageResponse<Card> selectMinions(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
                                            @RequestParam(value = "attack", required = false) Integer attack, @RequestParam(value = "health", required = false) Integer health,
                                            @RequestParam(value = "rarity", required = false) String rarity, @RequestParam(value = "race", required = false) String race,
                                            @RequestParam(value = "cardClass", required = false) String cardClass, @RequestParam(value = "cardSet", required = false) Integer cardSet,
                                            @RequestParam(value = "rule", required = false) String rule, @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {
        // System.out.println(pageNum + " " + pageSize);
        return cardService.selectMinions(name, cost, attack, health, rarity, race, cardClass, cardSet, rule, pageNum, pageSize);
    }

    @GetMapping("/spell")
    public PageResponse<Card> selectSpells(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
                                   @RequestParam(value = "rarity", required = false) String rarity, @RequestParam(value = "spellSchool", required = false) String spellSchool,
                                   @RequestParam(value = "cardClass", required = false) String cardClass, @RequestParam(value = "cardSet", required = false) Integer cardSet,
                                   @RequestParam(value = "rule", required = false) String rule, @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {

        return cardService.selectSpells(name, cost, rarity, rarity, spellSchool, cardClass, cardSet, rule, pageNum, pageSize);
    }

    @GetMapping("/weapon")
    public PageResponse<Card> selectWeapons(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
                                    @RequestParam(value = "attack", required = false) Integer attack, @RequestParam(value = "durability", required = false) Integer durability,
                                    @RequestParam(value = "rarity", required = false) String rarity, @RequestParam(value = "cardClass", required = false) String cardClass,
                                    @RequestParam(value = "cardSet", required = false) Integer cardSet, @RequestParam(value = "rule", required = false) String rule,
                                    @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {

        return cardService.selectWeapons(name, cost, attack, durability, rarity, cardClass, cardSet, rule, pageNum, pageSize);

    }

    @GetMapping("/hero")
    public PageResponse<Card> selectHeroes(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
                                   @RequestParam(value = "armor", required = false) Integer armor, @RequestParam(value = "health", required = false) Integer health,
                                   @RequestParam(value = "rarity", required = false) String rarity, @RequestParam(value = "cardClass", required = false) String cardClass,
                                   @RequestParam(value = "cardSet", required = false) Integer cardSet, @RequestParam(value = "rule", required = false) String rule,
                                   @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {


        return cardService.selectHeroes(name, cost, armor, health, rarity, cardClass, cardSet, rule, pageNum, pageSize);
    }

    @GetMapping("/heroPower")
    public PageResponse<Card> selectHeroPowers(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
                                       @RequestParam(value = "cardClass", required = false) String cardClass, @RequestParam(value = "rule", required = false) String rule,
                                       @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {

        return cardService.selectHeroPowers(name, cost, cardClass, rule, pageNum, pageSize);
    }

    @GetMapping("/location")
    public PageResponse<Card> selectLocations(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
                                      @RequestParam(value = "health", required = false) Integer health, @RequestParam(value = "rarity", required = false) String rarity,
                                      @RequestParam(value = "cardClass", required = false) String cardClass, @RequestParam(value = "cardSet", required = false) Integer cardSet,
                                      @RequestParam(value = "rule", required = false) String rule, @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {

        return cardService.selectLocations(name, cost, health, rarity, cardClass, cardSet, rule, pageNum, pageSize);
    }

    // @GetMapping("/all")
    // public PageResponse<Card> selectAll(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "cost", required = false) Integer cost,
    //                             @RequestParam(value = "cardClass", required = false) String cardClass, @RequestParam(value = "cardSet", required = false) Integer cardSet,
    //                             @RequestParam(value = "rule", required = false) String rule, @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
    //                             @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {
    //
    //     return cardService.selectAll(name, cost, cardClass, cardSet, rule, pageNum, pageSize);
    // }

    @GetMapping("/default")
    public PageResponse<Card> selectDefault(@RequestParam(value = "pageNum", required = true) Integer pageNum, @RequestParam(value = "pageSize", required = true)Integer pageSize) {
        return selectMinions(null, null, null, null, null, null, null, null, null, pageNum, pageSize);
    }
}
