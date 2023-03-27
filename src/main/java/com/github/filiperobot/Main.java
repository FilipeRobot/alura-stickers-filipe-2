package com.github.filiperobot;

import com.github.filiperobot.model.ClienteHttp;
import com.github.filiperobot.model.JsonParser;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // fazer uma conexão HTTP e buscar os top 250 filmes
        ClienteHttp cliente = new ClienteHttp("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
        //ClienteHttp cliente = new ClienteHttp("https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json");

        String json = cliente.getJson();

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);

        // exibir e manipular os dados

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

    }
}