package com.jaime.jaime.util;

public class TextoUtil {

    /**
     * Este metodo limita a quantidade de caracteres que irá aparecer no adpter do ListView
     * @param texto - recebe o texto vindo dos metodos de carga, variavel wikipediaTexto
     * @return - Um texto menor adaptavel ao ListView
     */
    public String limitarTamanhoTexto(String texto) {
        String retorno = texto;
        if (texto.length() > 100) {
            retorno = texto.substring(0, 100);
            retorno = texto.substring(0, retorno.lastIndexOf(" "));
            retorno += "...";
        }
        return retorno;
    }
}
