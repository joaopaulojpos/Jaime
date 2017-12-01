package com.jaime.jaime.util;

import android.content.Context;

import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.enums.EstabelecimentosEnum;

import java.util.ArrayList;
import java.util.List;

public class AlimentarBanco {

    TextoUtil textoUtil = new TextoUtil();

    public List<Estabelecimento> pegarListaEstabelecimentosAlimentada(Context context, String categoria) {
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        switch (categoria.toLowerCase()) {
            case "teatro":
                cargaTeatros(context);
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
                cargaShopping(context);
                break;
        }
        return estabelecimentos;
    }

    private void cargaShopping(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento e1 = new Estabelecimento();
        e1.setNome("Shopping Recife");
        String wikipediaTexto = "O Shopping Recife, antigo Shopping Center Recife, é um centro comercial de grande porte localizado no bairro de Boa Viagem, no Recife, estado de Pernambuco.";
        e1.setDescricao(textoUtil.limitarTamanhoTexto(wikipediaTexto));
        e1.setLocalPublico(0);
        e1.setEndereco("R. Padre Carapuceiro, 777 - Boa Viagem, Recife - PE, 51020-900");
        e1.setTelefone("(81) 3464-6464");
        e1.setSite("www.shoppingrecife.com.br");
        e1.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        e1.setImagem(4);
        e1.setNota(5);
        e1.setTotalVotos(50);
        e1.setHorarioAbre("09:00");
        e1.setHorarioFecha("22:00");
        e1.setLatitude(7878L);
        e1.setLongitude(456L);

        Estabelecimento e2 = new Estabelecimento();
        e2.setNome("Shopping Boa Vista");
        String wikipediaTexto2 = "";
        e2.setDescricao(textoUtil.limitarTamanhoTexto(wikipediaTexto2));
        e2.setLocalPublico(0);
        e2.setEndereco("R. do Giriquiti, 48 - Boa Vista, Recife - PE, 50070-010");
        e2.setTelefone("(81) 3423-5666");
        e2.setSite("www.shoppingboavista.com.br");
        e2.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        e2.setImagem(3);
        e2.setNota(4);
        e2.setTotalVotos(875);
        e2.setHorarioAbre("09:00");
        e2.setHorarioFecha("21:00");
        e2.setLatitude(545456L);
        e2.setLongitude(8488L);

        dao.salvar(e1);
        dao.salvar(e2);
    }

    public void cargaTeatros(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento e1 = new Estabelecimento();
        e1.setNome("Teatro de Santa Isabel");
        String wikipediaTexto = "O Teatro de Santa Isabel é um teatro localizado na cidade brasileira do Recife, capital do estado de Pernambuco. É um raro exemplo de genuína arquitetura neoclássica da primeira metade do século XIX brasileiro.";
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
        e1.setLatitude(45654L);
        e1.setLongitude(5555L);

        Estabelecimento e2 = new Estabelecimento();
        e2.setNome("Teatro RioMar Recife");
        String wikipediaTexto2 = "Teatro de 1000 assentos numerados com balcão superior e programação variada de espetáculos cênicos e cômicos.";
        e2.setDescricao(textoUtil.limitarTamanhoTexto(wikipediaTexto2));
        e2.setLocalPublico(0);
        e2.setEndereco("Av. República do Líbano, 251 - Pina, Recife - PE, 51110-160");
        e2.setTelefone("4003-1212");
        e2.setSite("www.teatroriomarrecife.com.br");
        e2.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        e2.setImagem(2);
        e2.setNota(2);
        e2.setTotalVotos(105);
        e2.setHorarioAbre("10:00");
        e2.setHorarioFecha("20:00");
        e2.setLatitude(45654L);
        e2.setLongitude(84849L);

        dao.salvar(e1);
        dao.salvar(e2);
    }
}
