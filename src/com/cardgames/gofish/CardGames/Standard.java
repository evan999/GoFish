package com.cardgames.gofish.CardGames;

import com.cardgames.gofish.CardGames.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Standard implements Deck {

    private List<Card> cards;
    private final static String[] SUITS = {"♦", "♥", "♣", "♠"};
    private final static int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15};

    public Standard() {
        cards = new ArrayList<>();
        for (var suit : SUITS){
            for (var value : VALUES){
                cards.add(new Card(value, suit));
            }
        }
    }

    @Override
    public void shuffle(){
        Collections.shuffle(cards);
    }

    @Override
    public Card draw() {
        return cards.remove(cards.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return cards.size() == 0;
    }
}
