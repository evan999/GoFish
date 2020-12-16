package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Deck;

public class Table {
    private Hand player = new Hand(new Player());
    private Deck deck = new Deck();
    private Player player2 = new Player();

    public Deck getDeck() {
        return deck;
    }

    public Hand getPlayer(){
        return player;
    }
}
