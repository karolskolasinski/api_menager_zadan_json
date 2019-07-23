package com.javagda25.tasks;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ScannerLoader {
    private static Scanner scanner = new Scanner(System.in);
    private static String command;

    public static void parser() {
        do {
            System.out.println("co chciałbyś zrobić? Create (c) Read (r) Update (u) Delete (d) Quit (q)");
            command = scanner.nextLine().toUpperCase();
            switch (command) {
                case "C":
                    Service.create(taskToSend(), Service.getNewUrl(command, ""));
                    break;
                case "R":
                    Service.read(Service.getNewUrl(command, ""));
                    break;
                case "U":
                    Service.update(taskToEdit(), Service.getNewUrl(command, ""));
                    break;
                case "D":
                    System.out.println("podaj numer zadania: ");
                    Service.delete(Service.getNewUrl(command, scanner.nextLine()));
                    break;
                case "Q":
                    break;
                default:
                    System.err.println("wybrano złą komendę, spróbuj jeszcze raz");
                    break;
            }
        } while (!command.equalsIgnoreCase("q"));
    }


    public static Task taskToEdit() {
        Task taskToEdit = new Task();
        System.out.println("podaj numer zadania");
        taskToEdit.setId(Long.parseLong(scanner.nextLine()));
        System.out.println("podaj treść: ");
        taskToEdit.setName(scanner.nextLine());
        taskToEdit.setCreationTime(LocalDateTime.now());
        System.out.println("czy wykonane? (true) (false)");
        taskToEdit.setDone(Boolean.parseBoolean(scanner.nextLine()));
        return taskToEdit;
    }


    public static Task taskToSend() {
        Task taskToEdit = new Task();
        System.out.println("Podaj treść: ");
        taskToEdit.setName(scanner.nextLine());
        taskToEdit.setCreationTime(LocalDateTime.now());
        System.out.println("czy wykonane? (true) (false)");
        taskToEdit.setDone(Boolean.parseBoolean(scanner.nextLine()));
        return taskToEdit;
    }
}
