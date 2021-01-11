package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Standard;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final Hand player = new Hand(new Player());
    private final Standard deck = new Standard();
    private final Hand opponent = new Hand(new Player());
    //private List<Player> players = new ArrayList<>();


    public Standard getDeck() {
        return deck;
    }

    public Hand getPlayer(){
        return player;
    }

    public Hand getOpponent() {
        return opponent;
    }

//    public Player addPlayer(){
//        return new Player();
//    }

}
