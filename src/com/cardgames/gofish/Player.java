package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards = new ArrayList<Card>();
    private int books;
    static Console console = new Console();


    public Player() {
        name = console.requestString("What is your name?");
    }


    public String getName(){
        return name;
    }

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
//
//    public void giveCard(){
//        // Give matching cards to opposing player
//
//    }

//    public Card requestCard(){
//
//    }

    public int getBooks(){
        return books;
    }
}
