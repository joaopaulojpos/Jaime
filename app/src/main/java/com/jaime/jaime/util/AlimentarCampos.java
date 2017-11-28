package com.jaime.jaime.util;

import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.enums.EstabelecimentosEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by leandro.cavalcanti on 27/11/2017.
 */

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
        e1.nome = "Teatro de Santa Isabel";
        String wikipediaTexto = "O Teatro de Santa Isabel é um teatro localizado na cidade brasileira do Recife, capital do estado de Pernambuco. É um raro exemplo de genuína arquitetura neoclássica da primeira metade do século XIX brasileiro.";
        e1.descricao = textoUtil.limitarTamanhoTexto(wikipediaTexto);
        e1.isPontoTuristico = true;
        e1.isLocalPublico = false;
        e1.endereco = "Praça da República, s/n - Santo Antônio, Recife - PE, 50010-040";
        e1.telefone = "(81) 3355-3323";
        e1.site = "www.teatrosantaisabel.com.br";
        e1.tipoEstabelecimento = EstabelecimentosEnum.TEATRO.toString();
        e1.imagem = 1;
        e1.nota = 4;
        e1.totalVotos = 248;
        e1.horarioAbre = "08:00";
        e1.horarioFecha = "22:00";

        Estabelecimento e2 = new Estabelecimento();
        e2.nome = "Teatro RioMar Recife";
        String wikipediaTexto2 = "Teatro de 1000 assentos numerados com balcão superior e programação variada de espetáculos cênicos e cômicos.";
        e2.descricao = textoUtil.limitarTamanhoTexto(wikipediaTexto2);
        e2.isPontoTuristico = false;
        e2.isLocalPublico = false;
        e2.endereco = "Av. República do Líbano, 251 - Pina, Recife - PE, 51110-160";
        e2.telefone = "4003-1212";
        e1.site = "www.teatroriomarrecife.com.br";
        e2.tipoEstabelecimento = EstabelecimentosEnum.TEATRO.toString();
        e2.imagem = 2;
        e2.nota = 2;
        e2.totalVotos = 105;
        e2.horarioAbre = "10:00";
        e2.horarioFecha = "20:00";

        estabelecimentos.add(e1);
        estabelecimentos.add(e2);
    }
}
