package com.github.filiperobot.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradoraDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo){
        try (inputStream) {
            // Leitura da imagem
            final String resourcesPath = "./src/main/resources/";

            BufferedImage imagemOriginal = ImageIO.read(inputStream);

            // Criar uma imagem em memória com transparencia e com tamanho novo
            int largura = imagemOriginal.getWidth();
            int altura = imagemOriginal.getHeight();

            int novaAltura = altura + 200;

            BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

            // Copiar a imagem original para novo imagem (em memória)
            Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
            graphics.drawImage(imagemOriginal, 0, 0, null);

            // Configurar texto da imagem
            Font font = new Font(Font.SANS_SERIF, Font.BOLD, 82);
            graphics.setFont(font);
            graphics.setColor(Color.YELLOW);

            // Escrever uma frase na nova imagem
            String texto = "Imersão JAVA ✌";
            FontMetrics metrics = graphics.getFontMetrics(font);
            int x = (largura - metrics.stringWidth(texto)) / 2;
            int y = novaAltura - 70;
            graphics.drawString(texto, x, y);

            // escrever a nova imagem em um arquivo
            File pasta = new File(resourcesPath + "img/saida");
            if (!pasta.exists()) {
                boolean mkdirs = pasta.mkdirs();
                if (mkdirs){
                    System.out.println("Pasta de saida de imagens criada: " + pasta.getCanonicalPath());
                }
            }
            ImageIO.write(novaImagem, "png", new File(pasta, nomeArquivo + ".png"));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
