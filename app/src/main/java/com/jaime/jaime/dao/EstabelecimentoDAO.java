package com.jaime.jaime.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.jaime.jaime.domain.Estabelecimento;

import java.util.ArrayList;
import java.util.List;


public class EstabelecimentoDAO extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public EstabelecimentoDAO(Context context) {
        super(context, "escola", null, 3);
    }


//MÉTODOS

    public void salvar(Estabelecimento estabelecimento) {
        //Montar o Dicionário de Dados = ContentValues
        ContentValues cv = getContentValues(estabelecimento);
        //pegar uma instância de SQLiteDatabe
        SQLiteDatabase db = getWritableDatabase();
        //insert
        if (estabelecimento.getId() == 0) {
            db.insert("estabelecimento", null, cv);
        } else {
            atualizar(estabelecimento);
        }

        /*String sql = "insert into estabelecimento (nome,email,telefone) values (\""+estabelecimento.getNome()+
                "\", \""+estabelecimento.getEmail()+"\",\""+estabelecimento.getTelefone()+"\");";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);*/
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
        cv.put("id", estabelecimento.getId());
        cv.put("imagem", estabelecimento.getImagem());
        cv.put("latitude", estabelecimento.getLatitude());
        cv.put("longitude", estabelecimento.getLongitude());
        cv.put("nota", estabelecimento.getNota());
        cv.put("site", estabelecimento.getSite());
        cv.put("telefone", estabelecimento.getTelefone());
        cv.put("totalvotos", estabelecimento.getTotalVotos());
        return cv;
    }

    public Estabelecimento atualizar(Estabelecimento estabelecimento) {
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

    public List<Estabelecimento> buscarEstabelecimentos() {
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
            estabelecimento.setLocalPublico(cursor.getInt(cursor.getColumnIndex("localpublico")) == 1);
            estabelecimento.setTotalVotos(cursor.getInt(cursor.getColumnIndex("totalvotos")));
            estabelecimento.setHorarioAbre(cursor.getString(cursor.getColumnIndex("horarioabre")));
            estabelecimento.setHorarioFecha(cursor.getString(cursor.getColumnIndex("horariofecha")));
            estabelecimento.setCategoria(cursor.getString(cursor.getColumnIndex("categoria")));
            estabelecimento.setLatitude(cursor.getLong(cursor.getColumnIndex("latitude")));
            estabelecimento.setLongitude(cursor.getLong(cursor.getColumnIndex("longitude")));

            estabelecimentos.add(estabelecimento);
        }
        return estabelecimentos;
    }
}
