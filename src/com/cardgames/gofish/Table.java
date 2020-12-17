package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Deck;

public class Table {
    private Hand player = new Hand(new Player());
    private Deck deck = new Deck();
    private Hand opponent = new Hand(new Player());

    public Deck getDeck() {
        return deck;
    }

    public Hand getPlayer(){
        return player;
    }

    public Hand getOpponent() {
        return opponent;
    }
}
