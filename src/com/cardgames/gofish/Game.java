package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

public class Game {
    Table table = new Table();
    private final static int cardsToDeal = 7;
    private final Console console = new Console();
    private boolean playerTurn = true;
//    Hand playerHand = table.getPlayer();
//    Hand opponentHand = table.getOpponent();

    public void play(){
        table.getDeck().shuffle();
        deal();
        do{
            while(playerTurn){
                System.out.println("\nPlayer 1: ");
                table.getPlayer().displayHand();
                System.out.print("\nPlayer 1- ");
                int ask = console.requestInt("What card do you want to ask for?: (2-13 or 15) ");
                fish(ask);

                if(gameOver()){
                    table.getPlayer().findPairs();
                    break;
                }
            }

            switchTurn();

            while(!playerTurn){
                System.out.println("\nPlayer 2: ");
                table.getOpponent().displayHand();
                System.out.print("\nPlayer 2- ");
                int ask = console.requestInt("What card do you want to ask for? (2-13 or 15) ");
                fish(ask);
//                System.out.println("\nPlayer 2: ");
//                table.getOpponent().displayHand();

                if(gameOver()){
                    table.getOpponent().findPairs();
                    break;
                }
            }

            switchTurn();

        } while(!gameOver());

        endGameResults();
    }

    private void deal(){
        for(int card  = 0; card < cardsToDeal; card++) {
            table.getPlayer().addCard(table.getDeck().draw());
            table.getOpponent().addCard(table.getDeck().draw());
        }
    }

    public void switchTurn(){
        for(int count = 0; count < 5; count++){
            System.out.println();
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
                    index--;
                }
            }
        }
        else{
            for (int index = 0; index < table.getPlayer().getCount(); index++){
                if(table.getPlayer().getCardValue(index) == value) {
                    found = true;
                    table.getOpponent().addCard(table.getPlayer().removeCard(index));
                    index--;
                }
            }
        }

        if(!found && playerTurn){
            System.out.println("\nGo Fish!");
//            table.getPlayer().findPairs();
            playerTurn = false;
            if(!table.getDeck().isEmpty()){
                Card drawn = table.getDeck().draw();
                System.out.println("Card drawn: " + drawn);
                table.getPlayer().addCard(drawn);
            }
            table.getPlayer().findPairs();
        }
        else if (!found && !playerTurn) {
            System.out.println("\nGo Fish!");

            playerTurn = true;
            if(!table.getDeck().isEmpty()){
                //System.out.println(table.getDeck().draw());
                Card drawn = table.getDeck().draw();
                System.out.println("Card drawn: " + drawn);
                table.getOpponent().addCard(drawn);
            }
            table.getOpponent().findPairs();

        }


    }

    public boolean gameOver(){
        return table.getPlayer().isEmpty() || table.getOpponent().isEmpty();
    }

    public void endGameResults(){
        System.out.println("\nPlayer 1 Pairs: " + table.getPlayer().getPairs());
        System.out.println("\nPlayer 2 Pairs: " + table.getOpponent().getPairs());

        if(table.getPlayer().getPairs() > table.getOpponent().getPairs()){
            System.out.println("Player 1 wins! Pairs: " + table.getPlayer().getPairs());
        }
        else if(table.getOpponent().getPairs() > table.getPlayer().getPairs()){
            System.out.println("\nPlayer 2 wins! Pairs: " + table.getOpponent().getPairs());
        }
        else{
            System.out.println("Draw!");
        }
    }
}
