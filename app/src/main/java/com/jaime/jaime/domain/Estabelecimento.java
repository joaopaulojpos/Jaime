package com.jaime.jaime.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.Serializable;

public class Estabelecimento implements Serializable{

    //Deixando tudo public por enquanto já q provavelmente vai ter campos deletados ou novos nessa classe,
    // ai pra ficar refazendo get set direto perde tempo

    public String nome;
    public String telefone;
    public String site;
    public String descricao;
    public String endereco;
    public String tipoEstabelecimento;
    public String horarioAbre;
    public String horarioFecha;
    public int nota;
    public int totalVotos;

    //N sei como é a localização, vou chutar que é latitude e longitude por enquanto e que são Long
    public Long latitude;
    public Long longitude;

    public int imagem; //0=imagem-teste

    //Opcionais
    public boolean isPontoTuristico;
    public boolean isLocalPublico;















}
