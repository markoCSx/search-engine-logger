package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/userlogs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            appMenu(bufferedWriter);

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchMenu (BufferedWriter bufferedWriter) {
        String userText = "";
        //Menu
        while (!userText.equalsIgnoreCase("x")) {
            System.out.print("""
                    ----------------
                    (X or x to exit)
                    SEARCH
                    Google:\t""");
            userText = userInput.nextLine().strip();
            logger(userText, bufferedWriter, true);

            if (userText.equalsIgnoreCase("x")){
                logger("exited Google", bufferedWriter, false);
                break;
            }

            System.out.print("""
                    ________________
                    searching.""");
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(".");
            }
            System.out.println("""
                    \nUnable to fetch results
                    Please try a different query""");
        }

    }


    public static void appMenu (BufferedWriter bufferedWriter) {
        String userText;
        //Menu
        int answer = 0;
        do {
            do {
                System.out.print("""
                        ----------------
                        1. Launch Google
                        2. Exit App
                        ----------------
                        """);
                userText = userInput.nextLine().strip();
                logger(userText, bufferedWriter, true);
            } while (!userText.equals("1") && !userText.equals("2"));

            answer = Integer.parseInt(userText);
            if (answer == 1) {
                logger("launched Google", bufferedWriter, false);
                searchMenu(bufferedWriter);
            }
        } while (answer != 2);
        logger("exited menu", bufferedWriter, false);
    }

    public static void logger (String userText,BufferedWriter bufferedWriter, boolean nL) {

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String loggedTime = dateTime.format(formatter);

        try {
            if (!nL) {
                bufferedWriter.write(" (" + userText + ")");
            }
            if (nL) {
                bufferedWriter.write("\n" + loggedTime + " " + userText);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
