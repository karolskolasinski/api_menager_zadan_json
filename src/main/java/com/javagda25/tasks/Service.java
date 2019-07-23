package com.javagda25.tasks;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Service {
    // operacje CRUD (Create Read Update Delete)
    private static Gson g = new Gson();
    private static HttpClient client = HttpClient.newBuilder().build();       // obiekt który reprezentuje POSTMAN'a
    private final static String url = "http://194.181.116.187:16666/task";

    /*CREATE-PUT*/
    static void create(Task task, String url) {
        String jsonTask = g.toJson(task);
        HttpRequest create = HttpRequest
                .newBuilder(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(jsonTask))
                .header("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = client.send(create, HttpResponse.BodyHandlers.ofString());
            System.out.println("Create success");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /*READ-GET*/
    static void read(String url) {
        // Zapytanie zwraca listę zadań.
        HttpRequest read = HttpRequest
                .newBuilder(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(read, HttpResponse.BodyHandlers.ofString());
            System.out.println(g.fromJson(response.body(), List.class));
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /*UPDATE-POST*/
    static void update(Task taskToEdit, String url) {
        String jsonTask = g.toJson(taskToEdit);
        HttpRequest update = HttpRequest
                .newBuilder(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(jsonTask))
                .header("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = client.send(update, HttpResponse.BodyHandlers.ofString());
            System.out.println("Update success");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /*DELETE-DELETE*/
    static void delete(String url) {
        // Zapytanie o usunięcie, na końcu zapytania mamy identyfikator elementu usuwanego
        // w wyniku otrzymujemy : true / false
        HttpRequest delete = HttpRequest
                .newBuilder(URI.create(url))
                .DELETE()
                .build();
        try {
            HttpResponse<String> response = client.send(delete, HttpResponse.BodyHandlers.ofString());
            if (g.fromJson(response.body(), Boolean.class)) {
                System.out.println("Delete success");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getNewUrl(String command, String taskNumber) {
        String url = Service.getUrl();
        if (command.equalsIgnoreCase("c") || command.equalsIgnoreCase("r") || command.equalsIgnoreCase("u")) {
            return url;
        }
        if (command.equalsIgnoreCase("d")) {
            StringBuilder stringBuilder = new StringBuilder(url).append("/").append(taskNumber);
            url = stringBuilder.toString();
        }
        return url;
    }
}
