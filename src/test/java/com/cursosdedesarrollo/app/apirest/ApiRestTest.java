package com.cursosdedesarrollo.app.apirest;

import org.json.simple.JSONArray;
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
        // System.out.println(responseBody);
        assertNotNull(responseBody, "El valor debe ser diferente a null");
        HttpHeaders httpHeaders = response.headers();
        assertEquals("application/json", httpHeaders.firstValue("content-type").get());
    }
    @Test
    public void testGetHttpBinOrgWithParams() throws IOException, InterruptedException, ParseException {
        // Given
        // configurar el cliente Web que haga la petición
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("https://httpbin.org/get?param1=hola&param2=23"))
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
        // Datos del body
        String responseBody = response.body();
        // System.out.println(responseBody);
        assertNotNull(responseBody, "El valor debe ser diferente a null");
        // Transformamos la string a un objeto Java JSON
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
        JSONObject args = (JSONObject) jsonObject.get("args");
        String param1 = (String )args.get("param1");
        // System.out.println("param1: "+ param1);
        assertEquals("hola", param1);
        String param2 = (String )args.get("param2");
        //System.out.println("param2: "+ param2);
        assertEquals("23", param2);
    }
    @Test
    public void testGetHttpBinOrgIPWithJson()
            throws IOException, InterruptedException, ParseException {
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
        // Status code
        int responseStatusCode = response.statusCode();
        assertEquals(
                200,
                responseStatusCode,
                "El código a devolver debería ser 200");
        // Datos de la caebecera
        HttpHeaders httpHeaders = response.headers();
        assertEquals("application/json", httpHeaders.firstValue("content-type").get());
        // Datos del body
        String responseBody = response.body();
        System.out.println(responseBody);
        assertNotNull(responseBody, "El valor debe ser diferente a null");
        // Transformamos la string a un objeto Java JSON
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
        // obtenemos el valor de un atributo del objeto JSON
        String origin = jsonObject.get("origin").toString();
        // verificamos su contenido
        assertNotNull(origin, "El origen debe ser diferente a null");
        System.out.println(origin);
    }
    @Test
    public void testGetHttpBinOrgWithJSON() throws IOException, InterruptedException, ParseException {
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
        // Extraemos el body de la respuesta
        String body = response.body();
        // Parsear el contenido del body
        JSONParser jsonParser = new JSONParser();
        JSONObject json = (JSONObject) jsonParser.parse(body);
        // Obtener los datos de los atributos que están dentro del JSON
        String url = json.get("url").toString();
        // Comprobamos que el es el contenido esperado
        assertEquals(
                "https://httpbin.org/get",
                url,
                "La url debe coincidir con el valor esperado");
        String origin = json.get("origin").toString();
        // Comprobamos que el es el contenido esperado
        assertNotNull(
                origin,
                "El origen no puede ser null");
    }

    // GET https://httpbin.org/headers
    @Test
    public void testGetHttpBinOrgHeaders()
            throws IOException, InterruptedException, ParseException {
        // Given
        // configurar el cliente Web que haga la petición
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create("https://httpbin.org/headers"))
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
        String body = response.body();
        //System.out.println(body);
        assertNotNull(body, "El body no puede ser null");
        // Parseamos el contenido del body
        JSONParser jsonParser = new JSONParser();
        JSONObject json = (JSONObject) jsonParser.parse(body);
        // Extraemos el atributo headers
        JSONObject headers = (JSONObject) json.get("headers");
        // extraemos el atributo Host de headers
        String host = headers.get("Host").toString();
        assertEquals("httpbin.org", host, "El host debería tener el nombre del host");
        // extraemos el atributo User-Agent de headers
        String userAgent = headers.get("User-Agent").toString();
        assertNotNull(userAgent, "El user Agent no puede ser null");
    }
    @Test
    public void testCursosDeDesarrolloPactometro() throws IOException, InterruptedException {
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
    public void testCursosDeDesarrolloPactometroWithJson() throws IOException, InterruptedException, ParseException {
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
        // Recogemos los datos del body
        String body = response.body();
        // Parseamos los datos
        JSONParser jsonParser = new JSONParser();
        JSONArray array = (JSONArray) jsonParser.parse(body);
        // System.out.println("tamaño: "+ array.size());
        assertEquals(16, array.size());
        // System.out.println(array);
        JSONObject partido = (JSONObject) array.get(0);
        String nombre = partido.get("nombre").toString();
        assertEquals("PP", nombre,
                "El nombre del primer partido del array debe ser PP");
        String dipu = partido.get("dipu").toString();
        assertEquals("89", dipu,
                "El número de diputados del primer partido del array debe ser 89");
        String imagen = partido.get("imagen").toString();
        assertEquals("logotipo-pp.png", imagen,
                "la imagen del primer partido del array debe ser logotipo-pp.png");
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
        obj.put("name", "David Vaquero");
        obj.put("age", 44);
        HttpRequest request = HttpRequest
                .newBuilder(new URI("https://httpbin.org/post"))
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

        assertEquals("David Vaquero",json.get("name"));
        assertEquals(44L,json.get("age"));
    }
    @Test
    public void testPutRequest() throws IOException, InterruptedException, URISyntaxException, ParseException {
        // Given
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        JSONObject obj = new JSONObject();
        obj.put("name", "David Vaquero");
        obj.put("age", 44);
        HttpRequest request = HttpRequest.newBuilder(new URI("https://httpbin.org/put"))
                .version(HttpClient.Version.HTTP_2)
                .method("PUT", HttpRequest.BodyPublishers.ofString(obj.toJSONString()))
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

        assertEquals("David Vaquero",json.get("name"));
        assertEquals(44L,json.get("age"));
    }
    @Test
    public void testTypiCodePostRequest() throws IOException, InterruptedException, URISyntaxException, ParseException {
        // Given
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        JSONObject obj = new JSONObject();
        obj.put("title", "El color de la magia");
        obj.put("body", "Terry Pratchett");
        obj.put("userId", 1);
        HttpRequest request = HttpRequest
                .newBuilder(new URI("https://jsonplaceholder.typicode.com/posts"))
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
                201,
                responseStatusCode);
        String responseBody = response.body();
        // System.out.println("reponseBody: " + responseBody);

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
        Long idValue = (Long) jsonObject.get("id");
        // System.out.println(idValue);
        assertEquals(101, idValue);
    }
    @Test
    public void testDeleteHttpBinOrg() throws IOException, InterruptedException, URISyntaxException {
        // Given
        // configurar el cliente Web que haga la petición
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(new URI("https://httpbin.org/delete"))
                .version(HttpClient.Version.HTTP_2)
                .method("DELETE",HttpRequest.BodyPublishers.ofString(""))
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
}
