package com.jaime.jaime.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.jaime.jaime.R;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * IMPLEMENTANDO A TELA DE SPLASH
         * Tela de introdução temporaria que faz dar um tempo
         * para que os outros componentes sejam carregados
         */

        //Escondendo a ActionBar
        getSupportActionBar().hide();

        // Exibir a Tela em FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Temporizador do Splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), CategoriaEstabelecimentosActivity.class));
                finish(); //Destruindo a Activity
            }
        }, 5000);
    }

}
