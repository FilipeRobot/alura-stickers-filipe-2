package com.github.filiperobot.controller;

import com.github.filiperobot.model.Conteudo;
import com.github.filiperobot.model.GeradoraDeFigurinhas;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MainController {
    GeradoraDeFigurinhas figurinha = new GeradoraDeFigurinhas();

    public String exibirContaudo(Conteudo conteudo) {
        String urlImage = conteudo.getUrlImagem();
        String imDbRating = conteudo.getRating();

        System.out.println("Titulo: " + colorize(conteudo.getTitle(), BOLD()));
        System.out.println("Poster: " + colorize(urlImage, BOLD()));

        if (imDbRating != null) {
            System.out.println(colorize("Classificação: " + colorize(imDbRating, BOLD()), TEXT_COLOR(255), MAGENTA_BACK()));
            for (int i = 0; i < Math.round(Double.parseDouble(imDbRating)); i++){
                System.out.print("⭐");
            }
        }
        System.out.println();
        return urlImage;
    }

    public void exibir(List<Conteudo> conteudos, boolean gerarFigurinha, Integer limit){
        for (int index = 0; index < limit; index++) {
            Conteudo conteudo = conteudos.get(index);

            String urlImage = exibirContaudo(conteudo);

            if (gerarFigurinha) {
                geraFigurinha(urlImage, index);
            }
        }
    }

    public void geraFigurinha(String urlImage, Integer num){
        try (InputStream inputStream = new URL(urlImage).openStream()) {
            figurinha.cria(inputStream, "figura" + (num + 1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
