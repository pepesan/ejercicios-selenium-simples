package com.cursosdedesarrollo.app.apirest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiRestTest {
    @Test
    public void testGetRequest() throws IOException, InterruptedException, ParseException {
        // Given
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("http://jsonplaceholder.typicode.com/posts/1"))
                .headers("Accept-Enconding", "gzip, deflate")
                .build();
        // When
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int responseStatusCode = response.statusCode();
        String responseBody = response.body();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
        // System.out.println("jsonObject: "+ jsonObject);
        // System.out.println("httpGetRequest: " + responseBody);
        // System.out.println("httpGetRequest status code: " + responseStatusCode);
        // Then
        assertEquals(
                200,
                responseStatusCode);
        assertEquals(
                "1",
                jsonObject.get("id").toString());
        assertEquals(
                "1",
                jsonObject.get("userId").toString());
        assertEquals(
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                jsonObject.get("title").toString());
        assertEquals(
                "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
                jsonObject.get("body").toString());


    }
    @Test
    public void testPostRequest() throws IOException, InterruptedException, URISyntaxException, ParseException {
        // Given
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        JSONObject obj = new JSONObject();
        obj.put("name", "Pankaj Kumar");
        obj.put("age", Integer.valueOf(32));
        HttpRequest request = HttpRequest.newBuilder(new URI("http://httpbin.org/post"))
                .version(HttpClient.Version.HTTP_2)
                .POST(HttpRequest.BodyPublishers.ofString(obj.toJSONString()))
                .build();
        // When
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int responseStatusCode = response.statusCode();
        String reponseBody = response.body();
        // System.out.println("httpGetRequest: " + reponseBody);
        // Then
        assertEquals(
                200,
                responseStatusCode);
        String responseBody = response.body();
        // System.out.println("reponseBody: " + responseBody);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
        JSONObject json = (JSONObject) jsonObject.get("json");

        assertEquals("Pankaj Kumar",json.get("name"));
    }
}
