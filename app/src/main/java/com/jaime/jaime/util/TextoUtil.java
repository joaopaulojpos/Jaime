package com.jaime.jaime.util;

public class TextoUtil {

    public String limitarTamanhoTexto(String texto, int limite) {
        String retorno = texto;
        if (texto.length() > limite) {
            retorno = texto.substring(0, limite);
            retorno = texto.substring(0, retorno.lastIndexOf(" "));
            retorno += "...";
        }
        return retorno;
    }
}
