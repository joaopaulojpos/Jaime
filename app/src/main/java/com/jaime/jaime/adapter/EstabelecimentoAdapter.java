package com.jaime.jaime.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jaime.jaime.R;
import com.jaime.jaime.domain.Estabelecimento;

import java.util.List;

public class EstabelecimentoAdapter extends BaseAdapter {

    //ATRIBUTOS

    Context context;
    List<Estabelecimento> estabelecimentos;

    //CONSTRUTOR

    public EstabelecimentoAdapter(Context context, List<Estabelecimento> estabelecimentos) {
        this.context = context;
        this.estabelecimentos = estabelecimentos;
    }
    //METODOS


    @Override
    public int getCount() {
        return estabelecimentos.size();
    }

    @Override
    public Object getItem(int position) {
        return estabelecimentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Passo 1
        Estabelecimento estabelecimento = estabelecimentos.get(position);

        // Passo 2 Criar View nova
        convertView = LayoutInflater.from(context).inflate(R.layout.estabelecimento_item, null);

        ImageView imgImagem = (ImageView) convertView.findViewById(R.id.img);
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);
        TextView tvDescricao = (TextView) convertView.findViewById(R.id.tvDescricao);

        //Passo 3
        Resources res = context.getResources();
        TypedArray imagens = res.obtainTypedArray(R.array.imagens);
        imgImagem.setImageDrawable(
                imagens.getDrawable(estabelecimento.imagem));
        ratingBar.setMax(5);
        ratingBar.setNumStars(estabelecimento.nota);
        tvDescricao.setText(estabelecimento.descricao);

        // Passo 4
        return convertView;

    }
}
