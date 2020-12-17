package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;
import com.cardgames.gofish.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int score;
    private Player player;
    //private boolean isEmpty = false;
    private int cardCount;

    public Hand(Player player){
        this.player = player;
    }

    public String getName(){
        return player.getName();
    }


    public int getCount(){
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public int getCardValue(int card){
        return cards.get(card).getValue();
    }

    public Card removeCard(int index){
        return cards.remove(index);
    }

    public String toString(){
        String output = "";
        for (var card : cards) {
            output += card + " ";
        }
        return output.trim();
    }

    public Card getCard(int index){
        // Get the matching card value from the player's hand.
        //
        return cards.get(index);
    }

    public boolean isPair() {
        if (cards.size() > 2) return false;
        return true;
    }

//    public void removePair(int value){
//        cards.removeIf(card -> card.getValue() == value);
//
////        for(var card : cards){
////            if(card.getValue() == value){
////                cards.remove(card);
////            }
////        }
//    }

    private boolean isEmpty(){
        if(cards.size() == 0){
            return true;
        }
        return false;
    }

    public void displayHand(){
        for (var card : cards){
            System.out.println(card.toString() + " ");
        }
    }

//    @Override
//    public String toString(){
//        String output = "";
//        for(var card : cards){
//            output += card
//        }
//    }



}
