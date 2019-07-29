package com.android.aaronbonilla.infoapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.aaronbonilla.infoapp.Home_screen;
import com.android.aaronbonilla.infoapp.R;
import android.view.View.OnClickListener;
import android.widget.Button;


public class PlanEstudio extends AppCompatActivity implements OnClickListener {

    private Button planback, btnIsc, btnIge, btnIi;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_estudio);
        //Declaracion de la orientacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();
    }
    //Para bloquear botonoes de navegacion
    @Override
    public void onBackPressed(){
    }

    //Accion de botones
    public void init() {
        planback = (Button) findViewById(R.id.planback);
        planback.setOnClickListener(this);
        btnIsc = (Button) findViewById(R.id.btnIsc);
        btnIsc.setOnClickListener(this);
        btnIge = (Button) findViewById(R.id.btnIge);
        btnIge.setOnClickListener(this);
        btnIi = (Button) findViewById(R.id.btnIi);
        btnIi.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.planback:
                Intent intents = new Intent(PlanEstudio.this, Home_screen.class);
                startActivity(intents);
                finish();
                break;

            case R.id.btnIsc:
                Intent intent1 = new Intent(PlanEstudio.this, Sistemas.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.btnIge:
                Intent intent2 = new Intent(PlanEstudio.this, Gestion.class);
                startActivity(intent2);
                finish();
                break;

            case R.id.btnIi:
                Intent intent4 = new Intent(PlanEstudio.this, Industrial.class);
                startActivity(intent4);
                finish();
                break;
        }
    }

}
