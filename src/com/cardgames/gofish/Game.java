package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    Table table = new Table();
    private final static int cardsToDeal = 7;
    // private List<Card> cards = new ArrayList<Card>();
    private final Console console = new Console();
    private boolean playerTurn = true;
    //private boolean goFish = false;
//    Hand playerHand = table.getPlayer();
//    Hand opponentHand = table.getOpponent();

    public void play(){
        table.getDeck().shuffle();
        deal();
        do{
            while(playerTurn){
                System.out.println("\nPlayer 1: ");
                table.getPlayer().displayHand();
                System.out.println("\nPlayer 2: ");
                table.getOpponent().displayHand();
                System.out.print("\nPlayer 1, ");
                int ask = console.requestInt("What card do you want to ask for?: (2-13 or 15) ");
                System.out.println("\nPlayer 2: ");
                table.getOpponent().displayHand();
                fish(ask);
                System.out.println("\nPlayer 1: ");
                table.getPlayer().displayHand();

                if(gameOver()){
                    break;
                }
            }

            while(!playerTurn){
                System.out.println("\nPlayer 2: ");
                table.getOpponent().displayHand();
                System.out.print("\nPlayer 2, ");
                int ask = console.requestInt("What card do you want to ask for? (2-13 or 15) ");
                fish(ask);
                System.out.println("\nPlayer 2: ");
                table.getOpponent().displayHand();

                if(gameOver()){
                    break;
                }
            }

        } while(!gameOver());

        endGameResults();
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

        if(playerTurn){
            for (int index = 0; index < table.getOpponent().getCount(); index++){
                if(table.getOpponent().getCardValue(index) == value) {
                    found = true;
                    table.getPlayer().addCard(table.getOpponent().removeCard(index));
                }
            }

//            table.getPlayer().findPairs();
        }
        else{
            for (int index = 0; index < table.getPlayer().getCount(); index++){
                if(table.getPlayer().getCardValue(index) == value) {
                    found = true;
                    table.getOpponent().addCard(table.getPlayer().removeCard(index));
                    index--;
                }
            }
//            table.getOpponent().findPairs();
        }

        if(!found && playerTurn){
            System.out.println(playerTurn);
            System.out.println("Go Fish!");
            playerTurn = false;
            table.getPlayer().addCard(table.getDeck().draw());
        }
        else if (!found && !playerTurn) {
            System.out.println(playerTurn);
            System.out.println("Go Fish!");
            playerTurn = true;
            table.getOpponent().addCard(table.getDeck().draw());
        }
    }

    private void displayHand(Hand hand) {
        System.out.println(hand);
        System.out.println(hand.getName() + " Pairs: " + hand.findPairs());
    }

    private void displayTable(){
        System.out.println(table.getPlayer().getName() + ": " + table.getPlayer());
    }

    public boolean gameOver(){

        if(table.getPlayer().isEmpty() || table.getOpponent().isEmpty()){
            return true;
        }
//        if(table.getDeck().isEmpty()){
//            return true;
//        }

        return false;
    }

    public void endGameResults(){
        if(table.getPlayer().getPairs() > table.getOpponent().getPairs()){
            System.out.println("Player 1 wins! Pairs: " + table.getPlayer().getPairs());
        }
        else if(table.getOpponent().getPairs() > table.getOpponent().getPairs()){
            System.out.println("Player 2 wins! Pairs: " + table.getOpponent().getPairs());
        }
        else{
            System.out.println("Draw!");
        }
    }
}
