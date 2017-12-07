package com.jaime.jaime.util;

public class TextoUtil {

    /**
     * Este metodo limita a quantidade de caracteres que irá aparecer no adpter do ListView
     * @param texto - recebe o texto vindo dos metodos de carga, variavel wikipediaTexto
     * @return - Um texto menor adaptavel ao ListView
     */
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
