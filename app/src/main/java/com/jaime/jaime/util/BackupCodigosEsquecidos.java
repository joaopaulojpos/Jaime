package com.jaime.jaime.util;

public class BackupCodigosEsquecidos {

    /**
     * Acho que nunca vamos usar esse método, deixa ele aqui e se não for usar mesmo exclui
     * @return
     *//*
    public List<Estabelecimento> listarTodosEstabelecimentos() {
        String sql = "select * from estabelecimento;";
        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Estabelecimento estabelecimento = new Estabelecimento();
            estabelecimento.setId(cursor.getInt(cursor.getColumnIndex("id")));
            estabelecimento.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            estabelecimento.setSite(cursor.getString(cursor.getColumnIndex("site")));
            estabelecimento.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            estabelecimento.setImagem(cursor.getInt(cursor.getColumnIndex("imagem")));
            estabelecimento.setNota(cursor.getInt(cursor.getColumnIndex("nota")));
            estabelecimento.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            estabelecimento.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            estabelecimento.setTotalVotos(cursor.getInt(cursor.getColumnIndex("totalVotos")));
            estabelecimento.setHorarioAbre(cursor.getString(cursor.getColumnIndex("horarioAbre")));
            estabelecimento.setHorarioFecha(cursor.getString(cursor.getColumnIndex("horarioFecha")));
            estabelecimento.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            estabelecimento.setLatitude(cursor.getLong(cursor.getColumnIndex("latitude")));
            estabelecimento.setLongitude(cursor.getLong(cursor.getColumnIndex("longitude")));
            estabelecimento.setLocalPublico(cursor.getInt(cursor.getColumnIndex("localPublico")));

            estabelecimentos.add(estabelecimento);
        }
        return estabelecimentos;
    }









            UtilTela utilTela = new UtilTela();
        Configuration configuration = getResources().getConfiguration();
        String orientacaoAtual = utilTela.descobrirOrientacao(configuration);
        View view = null;
        switch (orientacaoAtual) {
            case "landscape":
                view = inflater.inflate(R.layout.fragment_form_land, container, false);
                break;
            case "portrait":
                view = inflater.inflate(R.layout.fragment_form, container, false);
                break;
        }

*/
}
