package com.cardgames.gofish;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int score;
    //private boolean isEmpty = false;
    private int cardCount;


    private int getCount(){
        return cards.size();
    }

    private void addCard(Card card){
        cards.add(card);
    }

    public Card removeCard(int index){
        return cards.remove(index);
    }

    public boolean isPair() {
        if (cards.size() > 2) return false;
        return true;
    }

    public List<Card> removePair(){
        if(isPair() == true){

        }
    }

    private boolean isEmpty(){
        if(cards.size() == 0){
            return true;
        }
        return false;
    }

//    @Override
//    public String toString(){
//        String output = "";
//        for(var card : cards){
//            output += card
//        }
//    }



}
