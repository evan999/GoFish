package com.cardgames.gofish;

import com.cardgames.gofish.CardGames.Card;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSelector implements AI {

    SecureRandom randomCard = new SecureRandom();
    int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15};

    // Opponent player will use this interface for PvPAI game

    @Override
    public int request(){
        int rand = randomCard.nextInt(VALUES.length);
        return VALUES[rand];
    }


}
