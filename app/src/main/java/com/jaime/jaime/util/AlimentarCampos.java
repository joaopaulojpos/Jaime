package com.jaime.jaime.util;

import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.enums.EstabelecimentosEnum;

import java.util.ArrayList;
import java.util.List;

public class AlimentarCampos {

    TextoUtil textoUtil;
    List<Estabelecimento> estabelecimentos;

    public AlimentarCampos() {
        textoUtil = new TextoUtil();
    }

    public List<Estabelecimento> pegarListaEstabelecimentosAlimentada(String categoria) {
        estabelecimentos = new ArrayList<Estabelecimento>();
        switch (categoria.toLowerCase()) {
            case "teatro":
                alimentarTeatros();
                break;
            case "restaurante":

                break;
            case "hotel":

                break;
            case "igreja":

                break;
            case "praia":

                break;
            case "estacaodemetro":

                break;
            case "pontodeonibus":

                break;
            case "academia":

                break;
            case "padaria":

                break;
            case "supermercado":

                break;
            case "shopping":

                break;
        }
        return estabelecimentos;
    }


    private void alimentarTeatros() {
        Estabelecimento e1 = new Estabelecimento();
        e1.setNome("Teatro de Santa Isabel");
        String wikipediaTexto = "O Teatro de Santa Isabe" +
                "l é um teatro localizado na cidade brasileira do Recife, capital do estado de " +
                "Pernambuco. É um raro exemplo de genuína arquitetura neoclássica da primeira " +
                "metade do século XIX brasileiro.";
        e1.setDescricao(textoUtil.limitarTamanhoTexto(wikipediaTexto));
        e1.setLocalPublico(0);
        e1.setEndereco("Praça da República, s/n - Santo Antônio, Recife - PE, 50010-040");
        e1.setTelefone("(81) 3355-3323");
        e1.setSite("www.teatrosantaisabel.com.br");
        e1.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        e1.setImagem(1);
        e1.setNota(4);
        e1.setTotalVotos(248);
        e1.setHorarioAbre("08:00");
        e1.setHorarioFecha("22:00");

        Estabelecimento e2 = new Estabelecimento();
        e2.setNome("Teatro RioMar Recife");
        String wikipediaTexto2 = "Teatro de 1000 assentos numerados com balcão superior e " +
                "programação variada de espetáculos cênicos e cômicos.";
        e2.setDescricao(textoUtil.limitarTamanhoTexto(wikipediaTexto2));
        e2.setLocalPublico(0);
        e2.setEndereco("Av. República do Líbano, 251 - Pina, Recife - PE, 51110-160");
        e2.setTelefone("4003-1212");
        e1.setSite("www.teatroriomarrecife.com.br");
        e2.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        e2.setImagem(2);
        e2.setNota(2);
        e2.setTotalVotos(105);
        e2.setHorarioAbre("10:00");
        e2.setHorarioFecha("20:00");

        estabelecimentos.add(e1);
        estabelecimentos.add(e2);
    }


}
