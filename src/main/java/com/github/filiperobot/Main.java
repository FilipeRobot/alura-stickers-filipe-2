package com.github.filiperobot;

import com.github.filiperobot.model.ClienteHttp;
import com.github.filiperobot.model.GeradoraDeFigurinhas;
import com.github.filiperobot.model.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class Main {
    public static void main(String[] args) {
        // fazer uma conexão HTTP e buscar os top 250 filmes
        //ClienteHttp cliente = new ClienteHttp("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");
        ClienteHttp cliente = new ClienteHttp("https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json");

        String json = cliente.getJson();

        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(json);

        // exibir e manipular os dados

        var figurinha = new GeradoraDeFigurinhas();

        for (int index = 0; index < 1; index++) {
            var filme = listaDeFilmes.get(index);

            String title = filme.get("title");
            String urlImage = filme.get("image").replaceFirst("._.+_", "");

            System.out.println("Titulo: " + colorize(title, BOLD()));
            System.out.println("Poster: " + colorize(urlImage, BOLD()));
            System.out.println(colorize("Classificação: " + colorize(filme.get("imDbRating"), BOLD()), TEXT_COLOR(255), MAGENTA_BACK()));
            for (int i = 0; i < Math.round(Double.parseDouble(filme.get("imDbRating"))); i++){
                System.out.print("⭐");
            }
            System.out.println();

            try (InputStream inputStream = new URL(urlImage).openStream()) {
                figurinha.cria(inputStream, title);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println();
        }
    }
}