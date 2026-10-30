package com.pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    public static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        String userText;

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/userlogs.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            appMenu(fileWriter, bufferedWriter);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*System.out.print("Google: ");
        userText = userInput.nextLine();*/

    }

    public static void appMenu (FileWriter fileWriter, BufferedWriter bufferedWriter) {
        String userText;
        //Menu
        do {
            System.out.print("""
                1. Launch Google
                2. Exit App
                """);
            userText = userInput.nextLine();
            logger(userText, fileWriter, bufferedWriter);
        } while (!userText.equals("1") && !userText.equals("2"));

        int answer = Integer.parseInt(userText);
        if (answer == 1) {
            logger("launch", fileWriter, bufferedWriter);
        } else {
            logger("exit", fileWriter, bufferedWriter);
        }
    }

    public static void logger (String userText, FileWriter fileWriter, BufferedWriter bufferedWriter) {

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String loggedTime = dateTime.format(formatter);

        try {
            bufferedWriter.write(loggedTime + " " + userText + "\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
