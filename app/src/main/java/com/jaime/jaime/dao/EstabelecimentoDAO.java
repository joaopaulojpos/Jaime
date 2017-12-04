package com.jaime.jaime.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jaime.jaime.domain.Estabelecimento;

import java.util.ArrayList;
import java.util.List;


public class EstabelecimentoDAO extends SQLiteOpenHelper {
    //Toda vez que mudar o banco aumenta um nesse atributo.
    private static final int VERSAO = 31;


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Cria a tabela Estabelecimento
        String sql = "create table estabelecimento" +
                "(id integer primary key AUTOINCREMENT, " +
                "nome TEXT, " +
                "telefone TEXT, " +
                "site TEXT, " +
                "descricao TEXT, " +
                "endereco TEXT, " +
                "categoria TEXT, " +
                "horarioAbre TEXT, " +
                "horarioFecha TEXT, " +
                "nota REAL, " +
                "notaMedia REAL, " +
                "totalVotos integer, " +
                "latitude LONG, " +
                "longitude LONG, " +
                "imagem integer, " +
                "localPublico integer, " +
                "isFavorito integer, " +
                "anotacao TEXT);";
        sqLiteDatabase.execSQL(sql);
    }

    //Ao atualizarEstabelecimento a versão do banco esse método é acionado
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        atualizarTableEstabelecimento(sqLiteDatabase);
    }


    //CONSTRUTOR
    public EstabelecimentoDAO(Context context) {
        //contexto, nome do banco, não sei, versão do banco(se você adicionar um novo campo ou alterar algum,
        //ou excluir, é bom mudar a versão pra ele recriar o banco certo
        super(context, "jaime", null, VERSAO);
    }


//MÉTODOS

    public void salvarEstabelecimento(Estabelecimento estabelecimento) {
        //Montar o Dicionário de Dados = ContentValues
        ContentValues cv = getContentValues(estabelecimento);
        //pegar uma instância de SQLiteDatabe
        SQLiteDatabase db = getWritableDatabase();
        //Se o Id for zero, quer dizer que é um novo, se for diferente de zero
        // é porque ele já existia e tá sendo alterado.
        if (estabelecimento.getId() == 0) {
            estabelecimento = removerNullAtributoFavorito(estabelecimento);
            db.insert("estabelecimento", null, cv);
        } else {
            atualizarEstabelecimento(estabelecimento);
        }
    }

    private Estabelecimento removerNullAtributoFavorito(Estabelecimento estabelecimento) {
        //Como tá inserindo pela primeira vez ele nunca será Favorito, então já
        //será settado antes de ser inserido no banco
        if (estabelecimento.getIsFavorito() == null) {
            estabelecimento.setIsFavorito(0);
        }
        return estabelecimento;
    }

    @NonNull
    private ContentValues getContentValues(Estabelecimento estabelecimento) {
        ContentValues cv = new ContentValues();
        cv.put("nome", estabelecimento.getNome());
        cv.put("categoria", estabelecimento.getCategoria());
        cv.put("descricao", estabelecimento.getDescricao());
        cv.put("endereco", estabelecimento.getEndereco());
        cv.put("horarioabre", estabelecimento.getHorarioAbre());
        cv.put("horariofecha", estabelecimento.getHorarioFecha());
        cv.put("imagem", estabelecimento.getImagem());
        cv.put("latitude", estabelecimento.getLatitude());
        cv.put("longitude", estabelecimento.getLongitude());
        cv.put("nota", estabelecimento.getNota());
        cv.put("notaMedia", estabelecimento.getNotaMedia());
        cv.put("site", estabelecimento.getSite());
        cv.put("telefone", estabelecimento.getTelefone());
        cv.put("totalVotos", estabelecimento.getTotalVotos());
        cv.put("localPublico", estabelecimento.getLocalPublico());
        cv.put("isFavorito", estabelecimento.getIsFavorito());
        cv.put("anotacao", estabelecimento.getAnotacao());
        return cv;
    }

    public Estabelecimento atualizarEstabelecimento(Estabelecimento estabelecimento) {
        //Montar CV
        ContentValues cv = getContentValues(estabelecimento);
        //SQLiteDatabase
        SQLiteDatabase db = getWritableDatabase();
        //update
        String[] params = {estabelecimento.getId() + ""};
        int retorno = db.update("estabelecimento", cv, "id = ?", params);
        if (retorno > 0) {
            return estabelecimento;
        }
        return null;
    }


    public List<Estabelecimento> listarEstabelecimentos(String categoria) {
        categoria = categoria.toUpperCase();
        String sql = "select * from estabelecimento " +
                "WHERE categoria = '" + categoria + "';";
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
            estabelecimento.setNota(cursor.getFloat(cursor.getColumnIndex("nota")));
            estabelecimento.setNotaMedia(cursor.getFloat(cursor.getColumnIndex("notaMedia")));
            estabelecimento.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            estabelecimento.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            estabelecimento.setTotalVotos(cursor.getInt(cursor.getColumnIndex("totalVotos")));
            estabelecimento.setHorarioAbre(cursor.getString(cursor.getColumnIndex("horarioAbre")));
            estabelecimento.setHorarioFecha(cursor.getString(cursor.getColumnIndex("horarioFecha")));
            estabelecimento.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            estabelecimento.setLatitude(cursor.getLong(cursor.getColumnIndex("latitude")));
            estabelecimento.setLongitude(cursor.getLong(cursor.getColumnIndex("longitude")));
            estabelecimento.setLocalPublico(cursor.getInt(cursor.getColumnIndex("localPublico")));
            estabelecimento.setIsFavorito(cursor.getInt(cursor.getColumnIndex("isFavorito")));
            estabelecimento.setAnotacao(cursor.getString(cursor.getColumnIndex("anotacao")));

            estabelecimentos.add(estabelecimento);
        }
        return estabelecimentos;
    }

    public Estabelecimento listarEstabelecimento(int id) {
        String sql = "select * from estabelecimento " +
                "WHERE id = '" + id + "';";
        SQLiteDatabase db = getReadableDatabase();
        Estabelecimento estabelecimento = new Estabelecimento();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            estabelecimento.setId(cursor.getInt(cursor.getColumnIndex("id")));
            estabelecimento.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            estabelecimento.setSite(cursor.getString(cursor.getColumnIndex("site")));
            estabelecimento.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            estabelecimento.setImagem(cursor.getInt(cursor.getColumnIndex("imagem")));
            estabelecimento.setNota(cursor.getFloat(cursor.getColumnIndex("nota")));
            estabelecimento.setNotaMedia(cursor.getFloat(cursor.getColumnIndex("notaMedia")));
            estabelecimento.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            estabelecimento.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
            estabelecimento.setTotalVotos(cursor.getInt(cursor.getColumnIndex("totalVotos")));
            estabelecimento.setHorarioAbre(cursor.getString(cursor.getColumnIndex("horarioAbre")));
            estabelecimento.setHorarioFecha(cursor.getString(cursor.getColumnIndex("horarioFecha")));
            estabelecimento.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            estabelecimento.setLatitude(cursor.getLong(cursor.getColumnIndex("latitude")));
            estabelecimento.setLongitude(cursor.getLong(cursor.getColumnIndex("longitude")));
            estabelecimento.setLocalPublico(cursor.getInt(cursor.getColumnIndex("localPublico")));
            estabelecimento.setIsFavorito(cursor.getInt(cursor.getColumnIndex("isFavorito")));
            estabelecimento.setAnotacao(cursor.getString(cursor.getColumnIndex("anotacao")));
        }
        return estabelecimento;
    }


    //UTIL
    public void atualizarTableEstabelecimento(SQLiteDatabase sqLiteDatabase) {
        //dá um drop no banco e...
        String sql = "drop table estabelecimento;";
        sqLiteDatabase.execSQL(sql);
        //joga pro método onCreate que vai criar de novo
        onCreate(sqLiteDatabase);
    }

    //Dá um drop e create na tabela Estabelecimento
    public void resetarEstabelecimenteos() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        //dá um drop no banco e...
        String sql = "drop table estabelecimento;";
        sqLiteDatabase.execSQL(sql);
        //joga pro método onCreate que vai criar de novo
        onCreate(sqLiteDatabase);
    }
}
