package com.cursosdedesarrollo.app.apirest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiRestTest {

    @Test
    public void testGetHttpBinOrg() throws IOException, InterruptedException {
        // Given
        // configurar el cliente Web que haga la petición
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("https://httpbin.org/get"))
                .build();
        // When
        // realizar la petición
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());
        // Then
        // comprobar que la respuesta a nuestra petición es correcta
        int responseStatusCode = response.statusCode();
        assertEquals(
                200,
                responseStatusCode,
                "El código a devolver debería ser 200");
    }

    @Test
    public void testGetHttpBinOrgIP() throws IOException, InterruptedException {
        // Given
        // configurar el cliente Web que haga la petición
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("https://httpbin.org/ip"))
                .build();
        // When
        // realizar la petición
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());
        // Then
        // comprobar que la respuesta a nuestra petición es correcta
        int responseStatusCode = response.statusCode();
        assertEquals(
                200,
                responseStatusCode,
                "El código a devolver debería ser 200");
        String responseBody = response.body();
        System.out.println(responseBody);
        assertNotNull(responseBody, "El valor debe ser diferente a null");
        HttpHeaders httpHeaders = response.headers();
        assertEquals("application/json", httpHeaders.firstValue("content-type").get());
    }

    @Test
    public void testCursosDeDesarrollo() throws IOException, InterruptedException {
        // Given
        // configurar el cliente Web que haga la petición
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("https://cursosdedesarrollo.com/pactometro/resultados.json"))
                .build();
        // When
        // realizar la petición
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());
        // Then
        // comprobar que la respuesta a nuestra petición es correcta
        int responseStatusCode = response.statusCode();
        assertEquals(
                200,
                responseStatusCode,
                "El código a devolver debería ser 200");
    }
    @Test
    public void testGetRequest() throws IOException, InterruptedException, ParseException {
        // Given
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
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
        HttpRequest request = HttpRequest.newBuilder(new URI("https://httpbin.org/post"))
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
