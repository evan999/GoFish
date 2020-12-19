package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;
import com.cardgames.gofish.Player;

import java.util.*;

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
        return cards.size() == 0;
    }

    public void displayHand(){
        for (var card : cards){
            System.out.print(card.toString() + " ");
        }
    }

    public int findPairs(){
        HashMap<Integer, Integer> cardsInHand = new HashMap<>();

        for (var card : cards){
            if(cardsInHand.containsKey(card.getValue())){
                cardsInHand.put(card.getValue(), cardsInHand.get(card.getValue()) + 1);
            }
            else{
                cardsInHand.put(card.getValue(), 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : cardsInHand.entrySet()) {
            if(entry.getValue() >= 2){
//                System.out.println(entry.getKey());
                pairs += entry.getValue() / 2;
//                cards.remove(cards.getCard());
                System.out.println("\nPairs: " + pairs);
            }
        }

        return pairs;
    }

    public int getPairs(){
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
