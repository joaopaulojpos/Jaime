package com.jaime.jaime.util;

import android.content.res.Configuration;

public class UtilTela {


    /**
     *Quem chamar esse método tem que passar por parâmetro:
     *Configuration configuration = getResources().getConfiguration();@param configuration
     * @param configuration
     * @return
     */
    public String descobrirOrientacao(Configuration configuration) {
        String retorno;
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            retorno = "landscape";
        } else {
            retorno = "portrait";
        }
        return retorno;
    }
}
