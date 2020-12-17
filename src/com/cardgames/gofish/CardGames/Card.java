package com.cardgames.gofish.CardGames;

public class Card {
    private int value;
    private String suit;


    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return value;
    }

    public String toString() {
        String output = "";
        switch(value){
            case 11:
                output = "JK";
                break;
            case 12:
                output = "QU";
                break;
            case 13:
                output = "KI";
                break;
            case 15:
                output = "AC";
                break;
            default:
                output = value == 10 ? Integer.toString(value) : " " + value;
        }
        return output + suit;
    }
}
