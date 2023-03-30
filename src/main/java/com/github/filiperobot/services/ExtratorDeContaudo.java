package com.github.filiperobot.services;

import com.github.filiperobot.model.Conteudo;

import java.util.List;

public interface ExtratorDeContaudo {
    List<Conteudo> extraiContaudo(String json);
}
