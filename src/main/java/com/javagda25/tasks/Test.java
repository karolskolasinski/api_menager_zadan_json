//package com.javagda25.tasks;
//
//import com.google.gson.Gson;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.time.LocalDateTime;
//
//public class Test {
//    // operacje CRUD (Create Read Update Delete)
//​
//    public static void main(String[] args) {
//        HttpClient client = HttpClient
//                .newBuilder()
//                .build();       // obiekt który reprezentuje POSTMAN'a
//​
//        // Zapytanie o usunięcie, na końcu zapytania mamy identyfikator elementu usuwanego
//        // w wyniku otrzymujemy : true / false
//        HttpRequest request = HttpRequest
//                .newBuilder(URI.create("http://192.168.110.34:8080/task/34"))
//                .DELETE()
//                .build();
//​
//        // Zapytanie zwraca listę zadań.
//        //
////        HttpRequest request = HttpRequest
////                .newBuilder(URI.create("http://192.168.110.34:8080/task"))
////                .GET()
////                .build();
//        Gson g = new Gson();
//​
//        Task taskToEdit = new Task();
//        taskToEdit.setId(20L);
//        taskToEdit.setName("E.T go home!");
//        taskToEdit.setCreationTime(LocalDateTime.now());
//        taskToEdit.setDone(true);
//​
//        // zamiana obiekt -> tekst (json)
//        // marshaller - obiekt w tekst
//        String jsonTask = g.toJson(taskToEdit);
//​
//        System.out.println(jsonTask);
////        request = HttpRequest
////                .newBuilder(URI.create("http://192.168.110.34:8080/task"))
////                .POST(HttpRequest.BodyPublishers.ofString(jsonTask))
////                .header("Content-Type", "application/json")
////                .build();
//​
//        try {
//            // wysłanie przez klienta zapytania (request)
//            // BodyHandler klasa która w swojej metodzie apply mówi co ma się wydarzyć z wynikiem.
//​
//            // client to obiekt który może wywołać SEND i przesłać request, a w wyniku otrzymuje odpowiedź (zawartość strony)
//​
//            // HttpResponse.BodyHandlers.ofString() - to gotowy obiekt który "radzi sobie" z odpowiedzią.
//            //                                      został napisany w taki sposób by wyjście przepisać w postaci string'a
//            //                                      i zwrócić go w body obiektu HttpResponse.
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//​
//            // zmiana tekst -> obiekty
//            // unmarshaller
//            Boolean objects = g.fromJson(response.body(), Boolean.class);
//​
//            System.out.println(objects);
////            objects.forEach(System.out::println);
//​
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}