package com.jaime.jaime.util;

public class TextoUtil {

    public String limitarTamanhoTexto(String texto) {
        String retorno;
        retorno = texto.substring(0, 100);
        retorno = texto.substring(0, retorno.lastIndexOf(" "));
        retorno += "...";
        return retorno;
    }
}
