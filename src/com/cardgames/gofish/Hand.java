package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;
import com.cardgames.gofish.Player;

import java.util.*;

public class Hand {
    private List<Card> cards = new ArrayList<>();
    private int pairs = 0;
    private Player player;


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
                this.removePairs(entry.getKey());
                System.out.println("\nPairs: " + pairs);
            }
        }

        return pairs;
    }

    public void removePairs(int value){
        for(int card = 0; card < cards.size(); card++){
            if(cards.get(card).getValue() == value){
                System.out.println("Remove card from pair: " + cards.get(card).getValue());
                this.removeCard(card);
                card--;
            }
        }
    }

    public int getPairs(){
        return pairs;
    }
}
