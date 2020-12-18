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
//    Hand playerHand = table.getPlayer();
//    Hand opponentHand = table.getOpponent();

    public void play(){
        table.getDeck().shuffle();
        deal();
        System.out.println("Player 1: ");
        table.getPlayer().displayHand();
//        Card card = new Card(2, "SPADES");
//        table.getPlayer().addCard(card);

        System.out.println("Player 2: ");
        table.getOpponent().displayHand();
        int ask = console.requestInt("What card do you want to ask for? ");
        fish(ask);
//        table.getPlayer().removeCard(ask);
        System.out.println("Player 1: ");
        table.getPlayer().displayHand();
        System.out.println("Player 2: ");
        table.getOpponent().displayHand();
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
        for (int index = 0; index < table.getOpponent().getCount(); index++){
            if(table.getOpponent().getCardValue(index) == value) {
                found = true;
                // System.out.println(index);
                // table.getPlayer().removeCard(index);
                // Card matchingCard = table.getPlayer().removeCard(index);
//              table.getOpponent().addCard(matchingCard);
                table.getPlayer().addCard(table.getOpponent().removeCard(index));
//              cards.add(matchingCard);
            }
        }

//        for(var card : cards){
//            System.out.println(card);
//        }

        if(!found){
            System.out.println("Go Fish!");
            // table.getPlayer().addCard(table.getDeck().draw());
        }
    }

    private void displayHand(Hand hand) {
        System.out.println(hand);
        System.out.println(hand.getName() + " Pairs: " + hand.getPairs());
    }

    private void displayTable(){
        System.out.println(table.getPlayer().getName() + ": " + table.getPlayer());
    }

    public boolean gameOver(){

        if(table.getPlayer().isEmpty() || table.getOpponent().isEmpty()){
            return true;
        }

        if(table.getDeck().isEmpty()){
            return true;
        }

        return false;
    }

    public void endGameResults(){
        if(table.getPlayer().getPairs() > table.getOpponent().getPairs()){
            System.out.println("Player wins! Pairs: " + table.getPlayer().getPairs());
        }
        else if(table.getOpponent().getPairs() > table.getOpponent().getPairs()){
            System.out.println("Opponent wins! Pairs: " + table.getOpponent().getPairs());
        }
    }
}
