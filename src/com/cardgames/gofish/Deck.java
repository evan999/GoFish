package com.cardgames.gofish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;
    private final static String[] SUITS = {"DIAMONDS", "HEARTS", "CLUBS", "SPADES"};
    private final static int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15};
    private boolean isEmpty = false;

    public Deck() {
        cards = new ArrayList<>();
        for (var suit : SUITS){
            for (var value : VALUES){
                cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        if(cards.size() == 0) {
            return true;
        }
        return false;
    }
}
