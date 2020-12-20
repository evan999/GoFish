package com.cardgames.gofish.CardGames;

import java.util.Scanner;

public class Rigged implements Deck {
    private final static String[] SUITS = {"♤", "♥", "♧", "♦"};

    @Override
    public void shuffle() {
        return;
    }

    @Override
    public Card draw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Value: 2 - 13 or 15");
        int value = scanner.nextInt();
        System.out.println("Card suit 1 - 4");
        String suit = scanner.next();
        Card card = new Card(value, SUITS[Integer.parseInt(suit) - 1]);
        return card;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

