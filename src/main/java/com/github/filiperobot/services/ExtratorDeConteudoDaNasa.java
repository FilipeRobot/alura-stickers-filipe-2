package com.github.filiperobot.services;

import com.github.filiperobot.model.Conteudo;
import com.github.filiperobot.model.utils.JsonParser;

import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeContaudo {
    @Override
    public List<Conteudo> extraiContaudo(String json) {
        // extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream()
                .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
                .toList();
    }
}
