package com.github.filiperobot.model;

import java.util.List;

public interface ExtratorDeContaudo {
    List<Conteudo> extraiContaudo(String json);
}
