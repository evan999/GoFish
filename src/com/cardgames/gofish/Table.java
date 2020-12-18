package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Deck;

public class Table {
    private final Hand player = new Hand(new Player());
    private final Deck deck = new Deck();
    private final Hand opponent = new Hand(new Player());

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
