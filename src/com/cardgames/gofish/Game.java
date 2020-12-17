package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    Table table = new Table();
    private final static int cardsToDeal = 7;
    private List<Card> cards = new ArrayList<Card>();
    private Console console = new Console();

    public void play(){
        table.getDeck().shuffle();
        deal();
        System.out.println("Player 1: ");
        table.getPlayer().displayHand();
//        Card card = new Card(2, "SPADES");
//        table.getPlayer().addCard(card);

//        System.out.println("Player 2: ");
//        table.getOpponent().displayHand();
        int ask = console.requestInt("What card do you want to ask for? ");
        fish(ask);
//        table.getPlayer().removeCard(ask);
        System.out.println("Player 1: ");
        table.getPlayer().displayHand();
//        System.out.println("Player 2: ");
//        table.getOpponent().displayHand();
    }

    private void deal(){
        for(int card  = 0; card < cardsToDeal; card++) {
            table.getPlayer().addCard(table.getDeck().draw());
            table.getOpponent().addCard(table.getDeck().draw());
        }
    }

    public void fish(int value){
        // Player draws a card
        boolean found = false;
        // System.out.println(table.getPlayer().getCount());
        for (int index = 0; index < table.getPlayer().getCount(); index++){
            if(table.getPlayer().getCardValue(index) == value) {
                found = true;
                // System.out.println(index);
                table.getPlayer().removeCard(index);
                Card matchingCard = table.getPlayer().removeCard(index);
//                table.getOpponent().addCard(matchingCard);
//              cards.add(matchingCard);
            }
        }

//        for(var card : cards){
//            System.out.println(card);
//        }

        if(!found){
            System.out.println("Go Fish!");
        }
    }

    public void getBooks(){
        // Hashmap of cards in player hand
        // Detect if there's 4 of a value in hand.
        // Take the key and remove it from hand
        // Add 1 to books attribute
        HashMap<Integer, Integer> cardsInHand = new HashMap<>();

        
    }

//    public void requestCard(){
//        Card ask = cards.get(ask);
//
//        if(cards.contains(ask)){
//            cards.remove(ask);
//            // return ask;
//        }
//        else{
//            System.out.println("Go Fish!");
//            // return null
//        }
//    }

//    public void requestCard(Card card){
//        // System.out.println("What card do you want to ask for? (2-15): ");
//        //int requestValue = card.getValue();
//        if(cards.contains(card.getValue())) {
//            // Transfer cards to opposing player's hand.
//            for(var c : cards){
//                if(cards.indexOf(c) == 0){
//                    // give card
//                    giveCard();
//                }
//            }
//        }
//    }

    public void giveCard(){
        // Give matching cards to opposing player

    }

    private void displayTable(){
        System.out.println(table.getPlayer().getName() + ": " + table.getPlayer());
    }
}
