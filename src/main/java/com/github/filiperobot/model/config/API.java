package com.github.filiperobot.model.config;

import com.github.filiperobot.services.ExtratorDeContaudo;
import com.github.filiperobot.services.ExtratorDeConteudoDaApiLinguagens;
import com.github.filiperobot.services.ExtratorDeConteudoDaNasa;
import com.github.filiperobot.services.ExtratorDeConteudoDoImdb;

public enum API {
    IMDB_TOP_MOVIES_IMERSAO("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoImdb()),
    IMDB_TOP_MOVIES("https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json",
            new ExtratorDeConteudoDoImdb()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=", "2023-03-27", "2023-03-29", new ExtratorDeConteudoDaNasa()),
    LINGUAGENS("http://localhost:8080/linguagens", new ExtratorDeConteudoDaApiLinguagens());

    private final String url;
    private final ExtratorDeContaudo extrator;

    API(String url, ExtratorDeContaudo extrator){
        this.url = url;
        this.extrator = extrator;
    }
    API(String url, String startDate, String endDate, ExtratorDeContaudo extrator) {
        Propriedades prop = new Propriedades();
        this.url = url + prop.getProp("nasa.api.DEMO.key") + "&start_date=" + startDate + "&end_date=" + endDate;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeContaudo getExtrator() {
        return extrator;
    }
}
