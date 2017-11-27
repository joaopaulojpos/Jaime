package com.jaime.jaime.util;

/**
 * Created by leandro.cavalcanti on 27/11/2017.
 */

public class TextoUtil {

    public String limitarTamanhoTexto(String texto) {
        String retorno;
        retorno = texto.substring(0, 100);
        retorno = texto.substring(0, retorno.lastIndexOf(" "));
        retorno += "...";
        return retorno;
    }
}
