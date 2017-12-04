package com.jaime.jaime.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
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
        View view;
        ViewHolder viewHolder;



        if (convertView == null) {
            // Passo 2 Criar View nova
            view = LayoutInflater.from(context).inflate(R.layout.estabelecimento_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //Pega o estabelecimento selecionado
        Estabelecimento estabelecimento = estabelecimentos.get(position);


        /*imgEstabelecimento = (ImageView) view.findViewById(R.id.img);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        tvDescricao = (TextView) view.findViewById(R.id.tvDescricao);
        tvTotalVotos = (TextView) view.findViewById(R.id.tvTotalVotos);
        tvNome = (TextView) view.findViewById(R.id.tvNome);*/

        //Preenche os campos de acordo com o objeto
        viewHolder.tvNome.setText(estabelecimento.getNome());
        viewHolder.tvTotalVotos.setText("(" + estabelecimento.getTotalVotos() + ")");
        viewHolder.tvDescricao.setText(estabelecimento.getDescricao());
        viewHolder.ratingBar.setMax(5);
        viewHolder.ratingBar.setRating(estabelecimento.getNotaMedia());

        //Imagem
        Resources res = context.getResources();
        TypedArray imagens = res.obtainTypedArray(R.array.imagens);
        Log.i("Leandro", estabelecimento.getImagem() + "");
        viewHolder.imgEstabelecimento.setImageDrawable(imagens.getDrawable(estabelecimento.getImagem()));


        // Passo 4
        return view;

    }

    public class ViewHolder {
        final ImageView imgEstabelecimento;
        final RatingBar ratingBar;
        final TextView tvDescricao;
        final TextView tvTotalVotos;
        final TextView tvNome;

        public ViewHolder(View view){
            tvNome = view.findViewById(R.id.tvNome);
            imgEstabelecimento = view.findViewById(R.id.imgEstabelecimento);
            ratingBar = view.findViewById(R.id.ratingBar);
            tvDescricao = view.findViewById(R.id.tvDescricao);
            tvTotalVotos = view.findViewById(R.id.tvTotalVotos);
        }
    }
}
