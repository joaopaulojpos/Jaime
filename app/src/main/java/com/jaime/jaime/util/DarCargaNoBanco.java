package com.jaime.jaime.util;

import android.content.Context;
import android.util.Log;

import com.jaime.jaime.dao.EstabelecimentoDAO;
import com.jaime.jaime.domain.Estabelecimento;
import com.jaime.jaime.enums.EstabelecimentosEnum;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class DarCargaNoBanco {

    TextoUtil textoUtil = new TextoUtil();

    /**
     * Alimenta o baco de acordo com a categoria selecionada na tela dde categoria, recebendo a categoria
     * @param context - porque o app pede o contexto
     * @param categoria - recebe o parametro vindo do botão da tela de selecionar categoria
     * @return - Uma lista alimentada após a carga
     */
    public List<Estabelecimento> darCarga(Context context, String categoria) {
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        switch (categoria.toLowerCase()) {
            case "teatro":
                cargaTeatros(context);
                break;
            case "restaurante":
                cargaRestaurante(context);
                break;
            case "hotel":
                cargaHotel(context);
                break;
            case "igreja":
                cargaIgreja(context);
                break;
            case "praia":
                Log.i("Leandro", "Entrou nas praias");
                cargaPraia(context);
                break;
            case "estacaodemetro":
                cargaEstacao(context);
                break;
            case "pontodeonibus":
                cargaParada(context);
                break;
            case "academia":
                cargaAcademia(context);
                break;
            case "padaria":
                cargaPadaria(context);
                break;
            case "supermercado":
                cargaSupermercado(context);
                break;
            case "shopping":
                cargaShopping(context);
                break;
        }
        return estabelecimentos;
    }

    private void cargaIgreja(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento i1 = new Estabelecimento();
        i1.setNome("Igreja de Nossa Senhora da Boa Viagem");
        String wikipediaTexto = " Igreja histórica ainda em funcionamento. É comum passar por lá e " +
                "ver missas e casamentos sendo realizados. \n" +
                "A igreja está situada bem no meio da pracinha de Boa Viagem, rodeada pelas " +
                "barraquinhas de comércio de lanches, souvenires, artigos de praia e etc.";
        i1.setDescricao(wikipediaTexto);
        i1.setLocalPublico(0);
        i1.setEndereco("R. Barão de Souza Leão, s/n - Boa Viagem, Recife - PE, 51021-400");
        i1.setTelefone("(81) 3326-6161");
        i1.setSite("http://www.paroquiadaboaviagem.org/");
        i1.setCategoria(EstabelecimentosEnum.IGREJA.toString());
        i1.setImagem(0); // falta
        i1.setNotaMedia(5f);
        i1.setTotalVotos(0); // falta
        i1.setHorarioAbre("08:00");
        i1.setHorarioFecha("17:00");
        i1.setLatitude(0.0); // falta
        i1.setLongitude(0.0); // falta

        Estabelecimento i2 = new Estabelecimento();
        i2.setNome("Concatedral de São Pedro dos Clérigos");
        String wikipediaTexto2 = "A Concatedral de São Pedro dos Clérigos, também conhecida simplesmente" +
                " como Igreja de São Pedro dos Clérigos, é um templo católico situado no município " +
                "do Recife, capital do estado de Pernambuco, Brasil.";
        i2.setDescricao(wikipediaTexto2);
        i2.setLocalPublico(0);
        i2.setEndereco("Santo Antônio, Recife - PE, 50010-360");
        i2.setTelefone("");
        i2.setSite("");
        i2.setCategoria(EstabelecimentosEnum.IGREJA.toString());
        i2.setImagem(0); // falta
        i2.setNotaMedia(4f);
        i2.setTotalVotos(0); // falta
        i2.setHorarioAbre("");
        i2.setHorarioFecha("");
        i2.setLatitude(0.0); // falta
        i2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(i1);
        dao.salvarEstabelecimento(i2);
    }

    private void cargaPraia(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento p1 = new Estabelecimento();
        p1.setNome("Praia de Boa Viagem");
        String wikipediaTexto = "A Praia de Boa Viagem é a praia urbana mais famosa da cidade do " +
                "Recife, capital do estado de Pernambuco. ";
        p1.setDescricao(wikipediaTexto);
        p1.setLocalPublico(1);
        p1.setEndereco("Av. Boa Viagem - Pina, Recife - PE");
        p1.setTelefone("");
        p1.setSite("");
        p1.setCategoria(EstabelecimentosEnum.PRAIA.toString());
        p1.setImagem(7); // falta
        p1.setNotaMedia(4f);
        p1.setTotalVotos(130); // falta
        p1.setHorarioAbre("");
        p1.setHorarioFecha("");
        p1.setLatitude(-8.132141);
        p1.setLongitude(-34.899829);

        Estabelecimento p2 = new Estabelecimento();
        p2.setNome("Praia do Pina");
        String wikipediaTexto2 = "A Praia do Pina, também conhecida como Praia do Sport, é uma das duas praias da cidade do Recife, capital do estado de Pernambuco, Brasil. Está situada no bairro do Pina, zona sul da capital pernambucana.";
        p2.setDescricao(wikipediaTexto2);
        p2.setLocalPublico(1);
        p2.setEndereco("Av. Boa Viagem - Pina, Recife - PE, 51011-000");
        p2.setTelefone("");
        p2.setSite("");
        p2.setCategoria(EstabelecimentosEnum.PRAIA.toString());
        p2.setImagem(8); // falta
        p2.setNotaMedia(3f);
        p2.setTotalVotos(18); // falta
        p2.setHorarioAbre("");
        p2.setHorarioFecha("");
        p2.setLatitude(-8.095156);
        p2.setLongitude(-34.882063);

        Log.i(TAG, p1.getNome() + p2.getNome());
        dao.salvarEstabelecimento(p1);
        dao.salvarEstabelecimento(p2);
    }

    private void cargaAcademia(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento a1 = new Estabelecimento();
        a1.setNome("Academia Recife Santo Amaro ");
        String wikipediaTexto = "";
        a1.setDescricao(wikipediaTexto);
        a1.setLocalPublico(0);
        a1.setEndereco("Av. Gov. Agamenon Magalhães, 4102-4130 - Santo Amaro, Recife - PE, 50030-230");
        a1.setTelefone("");
        a1.setSite("http://www2.recife.pe.gov.br/servico/academia-recife");
        a1.setCategoria(EstabelecimentosEnum.ACADEMIA.toString());
        a1.setImagem(0); // falta
        a1.setNotaMedia(5f);
        a1.setTotalVotos(0); // falta
        a1.setHorarioAbre("05:00");
        a1.setHorarioFecha("23:00");
        a1.setLatitude(0.0); // falta
        a1.setLongitude(0.0); // falta

        Estabelecimento a2 = new Estabelecimento();
        a2.setNome("Yes Fit Academia");
        String wikipediaTexto2 = "";
        a2.setDescricao(wikipediaTexto2);
        a2.setLocalPublico(0);
        a2.setEndereco("R. Jean Emile Favre, 1312 - Ipsep, Recife - PE, 51190-450");
        a2.setTelefone("(81) 3031-9006");
        a2.setSite("http://www.yesfitacademia.com.br/yessite/iniciopge.aspx");
        a2.setCategoria(EstabelecimentosEnum.ACADEMIA.toString());
        a2.setImagem(0); // falta
        a2.setNotaMedia(4f);
        a2.setTotalVotos(0); // falta
        a2.setHorarioAbre("05:00");
        a2.setHorarioFecha("23:00");
        a2.setLatitude(0.0); // falta
        a2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(a1);
        dao.salvarEstabelecimento(a2);
    }

    private void cargaParada(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento p1 = new Estabelecimento();
        p1.setNome("");
        String wikipediaTexto = "";
        p1.setDescricao(wikipediaTexto);
        p1.setLocalPublico(0);
        p1.setEndereco("");
        p1.setTelefone("");
        p1.setSite("");
        p1.setCategoria("");
        p1.setImagem(0); // falta
        p1.setNotaMedia(5f);
        p1.setTotalVotos(0); // falta
        p1.setHorarioAbre("");
        p1.setHorarioFecha("");
        p1.setLatitude(0.0); // falta
        p1.setLongitude(0.0); // falta

        Estabelecimento p2 = new Estabelecimento();
        p2.setNome("");
        String wikipediaTexto2 = "";
        p2.setDescricao(wikipediaTexto2);
        p2.setLocalPublico(0);
        p2.setEndereco("");
        p2.setTelefone("");
        p2.setSite("");
        p2.setCategoria("");
        p2.setImagem(0); // falta
        p2.setNotaMedia(5f);
        p2.setTotalVotos(0); // falta
        p2.setHorarioAbre("");
        p2.setHorarioFecha("");
        p2.setLatitude(0.0); // falta
        p2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(p1);
        dao.salvarEstabelecimento(p2);
    }

    private void cargaEstacao(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento e1 = new Estabelecimento();
        e1.setNome("");
        String wikipediaTexto = "";
        e1.setDescricao(wikipediaTexto);
        e1.setLocalPublico(0);
        e1.setEndereco("");
        e1.setTelefone("");
        e1.setSite("");
        e1.setCategoria("");
        e1.setImagem(0); // falta
        e1.setNotaMedia(5f);
        e1.setTotalVotos(0); // falta
        e1.setHorarioAbre("");
        e1.setHorarioFecha("");
        e1.setLatitude(0.0); // falta
        e1.setLongitude(0.0); // falta

        Estabelecimento e2 = new Estabelecimento();
        e2.setNome("");
        String wikipediaTexto2 = "";
        e2.setDescricao(wikipediaTexto2);
        e2.setLocalPublico(0);
        e2.setEndereco("");
        e2.setTelefone("");
        e2.setSite("");
        e2.setCategoria("");
        e2.setImagem(0); // falta
        e2.setNotaMedia(5f);
        e2.setTotalVotos(0); // falta
        e2.setHorarioAbre("");
        e2.setHorarioFecha("");
        e2.setLatitude(0.0); // falta
        e2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(e1);
        dao.salvarEstabelecimento(e2);
    }

    private void cargaPadaria(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento p1 = new Estabelecimento();
        p1.setNome("");
        String wikipediaTexto = "";
        p1.setDescricao(wikipediaTexto);
        p1.setLocalPublico(0);
        p1.setEndereco("");
        p1.setTelefone("");
        p1.setSite("");
        p1.setCategoria("");
        p1.setImagem(0); // falta
        p1.setNotaMedia(5f);
        p1.setTotalVotos(0); // falta
        p1.setHorarioAbre("");
        p1.setHorarioFecha("");
        p1.setLatitude(0.0); // falta
        p1.setLongitude(0.0); // falta

        Estabelecimento p2 = new Estabelecimento();
        p2.setNome("");
        String wikipediaTexto2 = "";
        p2.setDescricao(wikipediaTexto2);
        p2.setLocalPublico(0);
        p2.setEndereco("");
        p2.setTelefone("");
        p2.setSite("");
        p2.setCategoria("");
        p2.setImagem(0); // falta
        p2.setNotaMedia(5f);
        p2.setTotalVotos(0); // falta
        p2.setHorarioAbre("");
        p2.setHorarioFecha("");
        p2.setLatitude(0.0); // falta
        p2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(p1);
        dao.salvarEstabelecimento(p2);
    }

    private void cargaSupermercado(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);


        Estabelecimento m1 = new Estabelecimento();
        m1.setNome("");
        String wikipediaTexto = "";
        m1.setDescricao(wikipediaTexto);
        m1.setLocalPublico(0);
        m1.setEndereco("");
        m1.setTelefone("");
        m1.setSite("");
        m1.setCategoria("");
        m1.setImagem(0); // falta
        m1.setNotaMedia(5f);
        m1.setTotalVotos(0); // falta
        m1.setHorarioAbre("");
        m1.setHorarioFecha("");
        m1.setLatitude(0.0); // falta
        m1.setLongitude(0.0); // falta

        Estabelecimento m2 = new Estabelecimento();
        m2.setNome("");
        String wikipediaTexto2 = "";
        m2.setDescricao(wikipediaTexto2);
        m2.setLocalPublico(0);
        m2.setEndereco("");
        m2.setTelefone("");
        m2.setSite("");
        m2.setCategoria("");
        m2.setImagem(0); // falta
        m2.setNotaMedia(5f);
        m2.setTotalVotos(0); // falta
        m2.setHorarioAbre("");
        m2.setHorarioFecha("");
        m2.setLatitude(0.0); // falta
        m2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(m1);
        dao.salvarEstabelecimento(m2);
    }

    private void cargaHotel(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento h1 = new Estabelecimento();
        h1.setNome("");
        String wikipediaTexto = "";
        h1.setDescricao(wikipediaTexto);
        h1.setLocalPublico(0);
        h1.setEndereco("");
        h1.setTelefone("");
        h1.setSite("");
        h1.setCategoria("");
        h1.setImagem(0); // falta
        h1.setNotaMedia(5f);
        h1.setTotalVotos(0); // falta
        h1.setHorarioAbre("");
        h1.setHorarioFecha("");
        h1.setLatitude(0.0); // falta
        h1.setLongitude(0.0); // falta

        Estabelecimento h2 = new Estabelecimento();
        h2.setNome("");
        String wikipediaTexto2 = "";
        h2.setDescricao(wikipediaTexto2);
        h2.setLocalPublico(0);
        h2.setEndereco("");
        h2.setTelefone("");
        h2.setSite("");
        h2.setCategoria("");
        h2.setImagem(0); // falta
        h2.setNotaMedia(5f);
        h2.setTotalVotos(0); // falta
        h2.setHorarioAbre("");
        h2.setHorarioFecha("");
        h2.setLatitude(0.0); // falta
        h2.setLongitude(0.0); // falta

        dao.salvarEstabelecimento(h1);
        dao.salvarEstabelecimento(h2);
    }

    private void cargaRestaurante(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento r1 = new Estabelecimento();
        r1.setNome("Restaurante Leite");
        String wikipediaTexto = "Culinária internacional refinada servida em restaurante centenário, de ambiente sofisticado com pianista.\n" +
                "Tranquilo - Ótimos coquetéis - Aconchegante";
        r1.setDescricao(wikipediaTexto);
        r1.setLocalPublico(0);
        r1.setEndereco("Praça Joaquim Nabuco, 147 - Santo Antônio, Recife - PE, 50010-480");
        r1.setTelefone("(81) 3224-7977");
        r1.setSite("www.restauranteleite.com.br");
        r1.setCategoria(EstabelecimentosEnum.RESTAURANTE.toString());
        r1.setImagem(5);
        r1.setNotaMedia(4.5f);
        r1.setTotalVotos(30); // falta
        r1.setHorarioAbre("11:00");
        r1.setHorarioFecha("16:00");
        r1.setLatitude(-8.064999);
        r1.setLongitude(-34.881330);

        Estabelecimento r2 = new Estabelecimento();
        r2.setNome("Ilha Sertaneja");
        String wikipediaTexto2 = "Escondidinhos e tapiocas, além de carne de sol e caldinhos de feijão, em ambiente rústico-contemporâneo.\n" +
                "COmida tarde da noite - Buffet à vontade - Tranquilo";
        r2.setDescricao(wikipediaTexto2);
        r2.setLocalPublico(0);
        r2.setEndereco("Rua Dr. Nilo Dornelas Câmara, 16 - Boa Viagem, Recife - PE, 51021-400");
        r2.setTelefone("(81) 3048-5886");
        r2.setSite("www.ilhasertaneja.com.br");
        r2.setCategoria(EstabelecimentosEnum.RESTAURANTE.toString());
        r2.setImagem(6);
        r2.setNotaMedia(4f);
        r2.setTotalVotos(144);
        r2.setHorarioAbre("11:00");
        r2.setHorarioFecha("00:00");
        r2.setLatitude(-8.131755);
        r2.setLongitude(-34.900919);

        dao.salvarEstabelecimento(r1);
        dao.salvarEstabelecimento(r2);
    }

    private void cargaShopping(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento s1 = new Estabelecimento();
        s1.setNome("Shopping Recife");
        String wikipediaTexto = "O Shopping Recife, antigo Shopping Center Recife, " +
                "é um centro comercial de grande porte localizado no bairro de Boa Viagem, " +
                "no Recife, estado de Pernambuco.";
        s1.setDescricao(wikipediaTexto);
        s1.setLocalPublico(0);
        s1.setEndereco("R. Padre Carapuceiro, 777 - Boa Viagem, Recife - PE, 51020-900");
        s1.setTelefone("(81) 3464-6464");
        s1.setSite("www.shoppingrecife.com.br");
        s1.setCategoria(EstabelecimentosEnum.SHOPPING.toString());
        s1.setImagem(4);
        s1.setNotaMedia(5f);
        s1.setTotalVotos(50);
        s1.setHorarioAbre("09:00");
        s1.setHorarioFecha("22:00");
        s1.setLatitude(-8.119593);
        s1.setLongitude(-34.904751);

        Estabelecimento s2 = new Estabelecimento();
        s2.setNome("Shopping Rio Mar");
        String wikipediaTexto2 = "O RioMar Shopping é um centro comercial de grande porte localizado na cidade do Recife. Inaugurado em 30 de outubro de 2012 e sendo considerado um dos shoppings mais luxuosos do Brasil, é o maior empreendimento comercial do Nordeste do Brasil, sendo o 5º maior do país (os 4 maiores são Shopping Leste Aricanduva, Shopping Interlagos, Novo Shopping Center e Shopping Parque D. Pedro) e o 1º do tipo fora do estado de São Paulo";
        s2.setDescricao(wikipediaTexto2);
        s2.setLocalPublico(0);
        s2.setEndereco("Av. República do Líbano, 251 - Pina, Recife - PE, 51110-160");
        s2.setTelefone("(81) 3878-0000");
        s2.setSite("www.riomarrecife.com.br");
        s2.setCategoria(EstabelecimentosEnum.SHOPPING.toString());
        s2.setImagem(3);
        s2.setNotaMedia(4.5f);
        s2.setTotalVotos(16300);
        s2.setHorarioAbre("09:00");
        s2.setHorarioFecha("22:00");
        s2.setLatitude(-8.085806);
        s2.setLongitude(-34.895097);

        dao.salvarEstabelecimento(s1);
        dao.salvarEstabelecimento(s2);
    }

    public void cargaTeatros(Context context) {
        EstabelecimentoDAO dao = new EstabelecimentoDAO(context);

        Estabelecimento t1 = new Estabelecimento();
        t1.setNome("Teatro de Santa Isabel");
        String wikipediaTexto = "O Teatro de Santa Isabel é um teatro localizado na " +
                "cidade brasileira do Recife, capital do estado de Pernambuco. " +
                "É um raro exemplo de genuína arquitetura neoclássica da primeira metade do " +
                "século XIX brasileiro.";
        t1.setDescricao(wikipediaTexto);
        t1.setLocalPublico(0);
        t1.setEndereco("Praça da República, s/n - Santo Antônio, Recife - PE, 50010-040");
        t1.setTelefone("(81) 3355-3323");
        t1.setSite("www.teatrosantaisabel.com.br");
        t1.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        t1.setImagem(1);
        t1.setNotaMedia(4.0f);
        t1.setNota(0.0f);
        t1.setTotalVotos(248);
        t1.setHorarioAbre("08:00");
        t1.setHorarioFecha("22:00");
        t1.setLatitude(-8.060876);
        t1.setLongitude(-34.878680);

        Estabelecimento t2 = new Estabelecimento();
        t2.setNome("Teatro RioMar Recife");
        String wikipediaTexto2 = "Teatro de 1000 assentos numerados com balcão superior e " +
                "programação variada de espetáculos cênicos e cômicos.";
        t2.setDescricao(wikipediaTexto2);
        t2.setLocalPublico(0);
        t2.setEndereco("Av. República do Líbano, 251 - Pina, Recife - PE, 51110-160");
        t2.setTelefone("4003-1212");
        t2.setSite("www.teatroriomarrecife.com.br");
        t2.setCategoria(EstabelecimentosEnum.TEATRO.toString());
        t2.setImagem(2);
        t2.setNotaMedia(2.0f);
        t2.setNota(0.0f);
        t2.setTotalVotos(105);
        t2.setHorarioAbre("10:00");
        t2.setHorarioFecha("20:00");
        t2.setLatitude(-8.086414);
        t2.setLongitude(-34.894266);

        dao.salvarEstabelecimento(t1);
        dao.salvarEstabelecimento(t2);
    }
}
