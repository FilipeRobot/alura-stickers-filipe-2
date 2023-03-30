package com.github.filiperobot;

import com.github.filiperobot.model.Conteudo;
import com.github.filiperobot.model.ExtratorDeContaudo;
import com.github.filiperobot.model.utils.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeContaudo {
    @Override
    public List<Conteudo> extraiContaudo(String json) {
        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // Popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String title = atributos.get("title");
            String urlImage = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String imDbRating = atributos.get("imDbRating");

            Conteudo conteudo = new Conteudo(title, urlImage, imDbRating);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
