package com.cardgames.gofish;

import java.util.Scanner;

public class Console implements UI {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int requestInt(String text){
        System.out.println(text);
        return scanner.nextInt();
    }

    @Override
    public String requestString(String text){
        System.out.println(text);
        return scanner.nextLine();
    }


}
