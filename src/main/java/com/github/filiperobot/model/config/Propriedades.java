package com.github.filiperobot.model.config;

import java.io.*;
import java.util.Properties;

public class Propriedades {
    private final Properties prop = new Properties();
    private final String fileConfigProperties = "./src/main/resources/properties/config.properties";

    public Propriedades() {
        loadProperties();
    }

    public String getProp(String key) {
        return prop.getProperty(key);
    }

    private void loadProperties(){
        try (FileInputStream file = new FileInputStream(fileConfigProperties)) {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProperties(String key, String value){
        try (OutputStream output = new FileOutputStream(fileConfigProperties)){
            prop.setProperty(key, value);
            prop.store(output, null);
            System.out.println("Propriedade \"" + key + "\" adicionada com sucesso com o valor \"" + value + "\"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
