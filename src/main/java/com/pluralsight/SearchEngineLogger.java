package com.pluralsight;

import java.util.Scanner;

public class SearchEngineLogger {

    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        String userText;
        menu();


        /*System.out.print("Google: ");
        userText = userInput.nextLine();*/

    }

    public static void menu () {
        String userText;
        //Menu
        do {
            System.out.print("""
                1. Launch Google
                2. Exit App
                """);
            userText = userInput.nextLine();
        } while (!userText.equals("1") && !userText.equals("2"));
        int answer = Integer.parseInt(userText);
    }

    public static void logger (String userInput) {

    }

}
