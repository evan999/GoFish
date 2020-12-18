package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;
import com.cardgames.gofish.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int pairs = 0;
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
        return cards.get(index);
    }

//    public boolean isPair() {
//        // Detect if cards are a pair
//        for(int i = 0; i < cards.size()-1; i++){
//            for(int j = i + 1; j < cards.size(); j++){
//                if(cards.get(i).getValue() == cards.get(j).getValue()){
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

//    public void removePair(int value){
//        cards.removeIf(card -> card.getValue() == value);
//
////        for(var card : cards){
////            if(card.getValue() == value){
////                cards.remove(card);
////            }
////        }
//    }

    public boolean isEmpty(){
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

    public int getPairs(){
        for(int i = 0; i < cards.size()-1; i++){
            for(int j = i + 1; j < cards.size(); j++){
                if(cards.get(i).getValue() == cards.get(j).getValue()){
                    pairs++;
                }
            }
        }

        return pairs;
    }

//    @Override
//    public String toString(){
//        String output = "";
//        for(var card : cards){
//            output += card
//        }
//    }



}
