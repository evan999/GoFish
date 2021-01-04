package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards = new ArrayList<Card>();
    // private int pairs;
    static Console console = new Console();


    public Player() {
        name = console.requestString("What is your name?");
    }


    public String getName(){
        return name;
    }

}
