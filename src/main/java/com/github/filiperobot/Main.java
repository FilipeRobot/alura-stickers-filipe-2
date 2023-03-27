package com.github.filiperobot;

import com.github.filiperobot.model.ClienteHttp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // fazer uma conexão HTTP e buscar os top 250 filmes
        ClienteHttp cliente = new ClienteHttp("https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json");

        System.out.println(cliente.getJson());

        // extrair só os dados que interessam (titulo, poster, classificação)

        // exibir e manipular os dados
    }
}