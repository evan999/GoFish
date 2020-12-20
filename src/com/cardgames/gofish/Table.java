package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Standard;

public class Table {
    private final Hand player = new Hand(new Player());
    private final Standard deck = new Standard();
    private final Hand opponent = new Hand(new Player());

    public Standard getDeck() {
        return deck;
    }

    public Hand getPlayer(){
        return player;
    }

    public Hand getOpponent() {
        return opponent;
    }
}
