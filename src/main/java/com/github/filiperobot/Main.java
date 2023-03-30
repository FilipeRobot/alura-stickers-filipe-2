package com.github.filiperobot;

import com.github.filiperobot.controller.MainController;
import com.github.filiperobot.model.ExtratorDeContaudo;
import com.github.filiperobot.model.web.ClienteHttp;
import com.github.filiperobot.model.config.Propriedades;

public class Main {
    private static final Propriedades prop = new Propriedades();
    private static final MainController controller = new MainController();

    public static void main(String[] args) {
        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url1 = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url2 = "https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json";
        String urlNasa = "https://api.nasa.gov/planetary/apod?api_key=" + prop.getProp("nasa.api.DEMO.key") + "&start_date=2023-03-27&end_date=2023-03-29";

        ClienteHttp clienteHttp = new ClienteHttp(urlNasa);

        String json = clienteHttp.getJson();

        // extrair só os dados que interessam (titulo, poster, classificação)
        ExtratorDeContaudo extrator = new ExtratorDeConteudoDaNasa();

        var conteudos = extrator.extraiContaudo(json);

        // exibir e manipular os dados

        for (int index = 0; index < 3; index++) {
            var urlImage = controller.exibirContaudo(conteudos.get(index));
            controller.geraFigurinha(urlImage, index);
        }

//        controller.exibir(conteudos, false, 3);
    }
}