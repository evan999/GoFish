package com.cardgames.gofish.CardGames;

public interface Deck {
    void shuffle();
    Card draw();
    boolean isEmpty();
}
