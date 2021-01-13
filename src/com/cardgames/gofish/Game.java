package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;
import com.cardgames.gofish.CardGames.Deck;

public class Game {
    Table table = new Table();
    private final static int cardsToDeal = 7;
    private final Console console = new Console();
    private boolean playerTurn = true;
    Hand playerHand = table.getPlayer();
    Hand opponentHand = table.getOpponent();
    Deck tableDeck = table.getDeck();
    RandomSelector randomSelector = new RandomSelector();

    public void play(){
        tableDeck.shuffle();
        deal();
        do{
            while(playerTurn){
                System.out.println("\nPlayer 1: ");
                playerHand.displayHand();
                System.out.print("\nPlayer 1- ");
                int ask = console.requestInt("What card do you want to ask for?: (2-13 or 15) ");
                request(ask);

                if(gameOver()){
                    playerHand.findPairs();
                    break;
                }
            }

            while(!playerTurn){
                System.out.println("\nPlayer 2: ");
                opponentHand.displayHand();
                System.out.print("\nPlayer 2- ");
                int ask = console.requestInt("What card do you want to ask for? (2-13 or 15) ");
                request(ask);

                if(gameOver()){
                    opponentHand.findPairs();
                    break;
                }
            }

        } while(!gameOver());

        endGameResults();
    }

    private void deal(){
        for(int card = 0; card < cardsToDeal; card++) {
            playerHand.addCard(tableDeck.draw());
            opponentHand.addCard(tableDeck.draw());
        }
    }

//    public void switchTurn(){
//        for(int count = 0; count < 50; count++){
//            System.out.println();
//        }
//    }

//    public boolean request(int value){
//
//        if(playerTurn){
//
//        }
//    }

//    public void getCardFromPlayer(){
//        opponentHand.addCard(table.getPlayer().removeCard(index));
//        index--;
//    }



    public boolean findMatch(int value){

        if(playerTurn){
            for (int index = 0; index < opponentHand.getCount(); index++){
                if(opponentHand.getCardValue(index) == value) {
//                    found = true;
                    playerHand.addCard(opponentHand.removeCard(index));
                    index--;
                    return true;
                }
            }
        }
        else{
            for (int index = 0; index < playerHand.getCount(); index++){
                if(playerHand.getCardValue(index) == value) {
//                found = true;
                    opponentHand.addCard(table.getPlayer().removeCard(index));
                    index--;
                    return true;
                }
            }
        }

        return false;
    }

    public void fish(){
        System.out.println("\nGo Fish!");
//            table.getPlayer().findPairs();
        if(playerTurn){
            playerTurn = false;
            if(!tableDeck.isEmpty()){
                Card drawn = tableDeck.draw();
                System.out.println("Card drawn: " + drawn);
                playerHand.addCard(drawn);
            }
            playerHand.findPairs();
        }
        else{
            playerTurn = true;
            if(!tableDeck.isEmpty()){
                Card drawn = tableDeck.draw();
                System.out.println("Card drawn: " + drawn);
                opponentHand.addCard(drawn);
            }
            opponentHand.findPairs();
        }
    }

    public void request(int value){
        findMatch(value);

    }

//    public void request(int value){
//        // Player draws a card
//        boolean found = false;
//
//        if(playerTurn){
//            for (int index = 0; index < opponentHand.getCount(); index++){
//                if(opponentHand.getCardValue(index) == value) {
//                    found = true;
//                    playerHand.addCard(opponentHand.removeCard(index));
//                    index--;
//                }
//            }
//        }
//        else{
//            for (int index = 0; index < playerHand.getCount(); index++){
//                if(playerHand.getCardValue(index) == value) {
//                    found = true;
//                    opponentHand.addCard(table.getPlayer().removeCard(index));
//                    index--;
//                }
//            }
//        }
//
//        if(!found && playerTurn){
//            System.out.println("\nGo Fish!");
////            table.getPlayer().findPairs();
//            playerTurn = false;
//            if(!tableDeck.isEmpty()){
//                Card drawn = tableDeck.draw();
//                System.out.println("Card drawn: " + drawn);
//                playerHand.addCard(drawn);
//            }
//            playerHand.findPairs();
//        }
//        else if (!found && !playerTurn) {
//            System.out.println("\nGo Fish!");
//
//            playerTurn = true;
//            if(!tableDeck.isEmpty()){
//                Card drawn = tableDeck.draw();
//                System.out.println("Card drawn: " + drawn);
//                opponentHand.addCard(drawn);
//            }
//            opponentHand.findPairs();
//        }
//    }



    public boolean gameOver(){
        return playerHand.isEmpty() || opponentHand.isEmpty();
    }

    public void endGameResults(){
        System.out.println("\nPlayer 1 Pairs: " + playerHand.getPairs());
        System.out.println("\nPlayer 2 Pairs: " + opponentHand.getPairs());

        if(playerHand.getPairs() > opponentHand.getPairs()){
            System.out.println("Player 1 wins! Pairs: " + playerHand.getPairs());
        }
        else if(opponentHand.getPairs() > playerHand.getPairs()){
            System.out.println("\nPlayer 2 wins! Pairs: " + opponentHand.getPairs());
        }
        else{
            System.out.println("Draw!");
        }
    }
}
