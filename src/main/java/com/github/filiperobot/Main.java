package com.github.filiperobot;

import com.github.filiperobot.controller.MainController;
import com.github.filiperobot.model.config.API;
import com.github.filiperobot.services.ExtratorDeContaudo;
import com.github.filiperobot.model.web.ClienteHttp;
import com.github.filiperobot.model.config.Propriedades;

public class Main {
    private static final MainController controller = new MainController();

    public static void main(String[] args) {
        // fazer uma conexão HTTP e buscar os top 250 filmes
        API api = API.IMDB_TOP_MOVIES_IMERSAO;

        ClienteHttp clienteHttp = new ClienteHttp(api.getUrl());

        String json = clienteHttp.getJson();

        // extrair só os dados que interessam (titulo, poster, classificação)
        ExtratorDeContaudo extrator = api.getExtrator();//new ExtratorDeConteudoDaNasa();

        var conteudos = extrator.extraiContaudo(json);

        // exibir e manipular os dados

        for (int index = 0; index < 3; index++) {
            var conteudo = conteudos.get(index);

            controller.exibirContaudo(conteudo);

            controller.geraFigurinha(conteudo.getUrlImagem(), conteudo.getTitle());
        }

//        controller.exibir(conteudos, false, 3);
    }
}