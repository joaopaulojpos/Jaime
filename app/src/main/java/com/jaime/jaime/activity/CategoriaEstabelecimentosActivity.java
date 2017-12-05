package com.jaime.jaime.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jaime.jaime.MapsTeste.TesteMapsActivity;
import com.jaime.jaime.R;
import com.jaime.jaime.apiclima.Clima;
import com.jaime.jaime.apiclima.ClimaResposta;
import com.jaime.jaime.apiclima.ClimaapiService;
import com.jaime.jaime.teste.TesteActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoriaEstabelecimentosActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRestaurante;
    private Button btnBar;
    private Button btnTeatro;
    private Button btnClima;
    private Intent intent;
    private Button btnShopping;

    //ATRIBUTOS Teste commit


    //METODOS

    private static final String TAG = "CLIMEX";
    private Retrofit retrofit;
    private Button btnLeandro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_estabelecimentos);

        pegarReferencias();
        listenarBotoes();

        /**
         * Criando uma instâcia do Retrofit e passando a url base para fazer a requisição
         * com o resultado da requisição já se faz a conversão GSON
         */
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.hgbrasil.com/weather/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obterDados();

    }

    /**
     * Implementação do metódo de obtenção de dados, aqui ocorre o response vindo do GET
     */
    public void obterDados(){
        ClimaapiService service = retrofit.create(ClimaapiService.class);
        Call<ClimaResposta> climaRespostaCall = service.obterListaClimas();

        climaRespostaCall.enqueue(new Callback<ClimaResposta>() {
            @Override
            public void onResponse(Call<ClimaResposta> call, Response<ClimaResposta> response) {
                if (response.isSuccessful()){

                    ClimaResposta climaResposta = response.body();
                    Clima listaClima = climaResposta.getResults();

                    String data = listaClima.getDate();
                    String situacao = listaClima.getCurrently();
                    String descricao = listaClima.getDescription();
                    String condicao_tempo = listaClima.getCondition_slug();

                    if ( listaClima.getCurrently().equals("noite")){
                        Log.i(TAG, " Clima " + listaClima.getDescription());
                        //  Log.i(TAG, " Data " + listaClima.getDate());
                        Log.i(TAG, " Situação " + listaClima.getCurrently());
                        Log.i(TAG, "Clima " + listaClima.getCondition_slug());
                        Log.i(TAG, "ENTROU NO IF");
                    }
                    gerarNotificacao(listaClima.getCondition_slug());

                }else {
                    Log.e(TAG," onResponse " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ClimaResposta> call, Throwable t) {
                Log.e(TAG, " onFailure " + t.getMessage());
            }
        });
    }

    /**
     * Métood de implementaçao da Notification Local, Utilizamos a classe NotificationManager para execução
     * @param condicao - utilizado para definir em qual condição do if para o texto de notificação
     */
    public void gerarNotificacao(String condicao){

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, CategoriaEstabelecimentosActivity.class), 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("Ticker Texto");
        builder.setContentTitle("Aviso de Clima - Jaime App");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
        builder.setContentIntent(p);

        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        if (condicao.equals("cloudly_night") || condicao.equals("cloudly_day")){
            String [] descs = new String[]{" OPS, a previsão hoje é de Tempo","Parcialmente Nublado Previna-se, ", " e leve consigo um guarda chuva"};
            for(int i = 0; i < descs.length; i++){
                style.addLine(descs[i]);
            }
        } else if (condicao.equals("cloud")) {
            String[] descs = new String[]{" Olá, a previsão hoje é de Tempo Nublado ", "Se eu você, levaria um guarda chuva"};
            for (int i = 0; i < descs.length; i++) {
                style.addLine(descs[i]);
            }
        }else if (condicao.equals("storm")){
            String[] descs = new String[]{" Olá, a previsão hoje é de Tempestades então", " prepare sua capa ou seu guarda chuva e", " tome muito cuidado !"};
            for (int i = 0; i < descs.length; i++) {
                style.addLine(descs[i]);
            }
        }else if (condicao.equals("rain")){
            String[] descs = new String[]{" Olá, a previsão hoje é de muita chuva, tome muito cuidado", "por onde anda de preferência fique em casa. "};
            for (int i = 0; i < descs.length; i++) {
                style.addLine(descs[i]);
            }
        } else if (condicao.equals("clear_night") || condicao.equals("clear_day")){
            String[] descs = new String[]{" Olá, a previsão hoje é de Céu de limpo ", "então aproveita e vai explorar os lugares ", "conheçer coisas novas, Divirta-se. "};
            for (int i = 0; i < descs.length; i++) {
                style.addLine(descs[i]);
            }
        }
        builder.setStyle(style);

        Notification n = builder.build();
        n.flags = Notification.FLAG_AUTO_CANCEL;
        nm.notify(R.drawable.ic_launcher_background, n);

        try{
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(this, som);
            toque.play();
        }
        catch(Exception e){}
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(CategoriaEstabelecimentosActivity.this, SelecionarLocalActivity.class);
        switch (v.getId()) {
            case R.id.btnRestaurante:
                intent.putExtra("Categoria", "Restaurante");
                break;
            case R.id.btnBar:
                intent.putExtra("Categoria", "Bar");
                break;
            case R.id.btnTeatro:
                intent.putExtra("Categoria", "Teatro");
                break;
            case R.id.btnShopping:
                intent.putExtra("Categoria", "Shopping");
                break;
            case R.id.btnLeandro:
                intent = new Intent(CategoriaEstabelecimentosActivity.this, TesteActivity.class);
                break;

        }
        startActivity(intent);
    }


    public void pegarReferencias() {
        btnRestaurante = findViewById(R.id.btnRestaurante);
        btnBar = findViewById(R.id.btnBar);
        btnTeatro = findViewById(R.id.btnTeatro);
        btnShopping = findViewById(R.id.btnShopping);
        btnLeandro = (Button) findViewById(R.id.btnLeandro);
    }

    public void listenarBotoes() {
        btnRestaurante.setOnClickListener(this);
        btnBar.setOnClickListener(this);
        btnTeatro.setOnClickListener(this);
        btnShopping.setOnClickListener(this);
        btnLeandro.setOnClickListener(this);
    }
}
