package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

public class Game {
    Table table = new Table();

    public void play(){
        table.getDeck().shuffle();
        deal();
        table.getPlayer();
    }

    private void deal(){
        for(int card  = 0; card < 7; card++) {
            table.getPlayer().addCard(table.getDeck().draw());
        }
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
