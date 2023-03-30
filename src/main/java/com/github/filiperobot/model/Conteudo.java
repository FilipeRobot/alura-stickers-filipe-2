package com.github.filiperobot.model;

public class Conteudo {
    private final String title;
    private final String urlImagem;
    private final String Rating;

    public Conteudo(String title, String urlImagem) {
        this.title = title;
        this.urlImagem = urlImagem;
        this.Rating = null;
    }

    public Conteudo(String title, String urlImagem, String Rating) {
        this.title = title;
        this.urlImagem = urlImagem;
        this.Rating = Rating;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getRating() {
        return Rating;
    }
}
