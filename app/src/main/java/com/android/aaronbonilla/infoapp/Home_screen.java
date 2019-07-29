package com.android.aaronbonilla.infoapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.android.aaronbonilla.infoapp.Activities.FichasActivity;
import com.android.aaronbonilla.infoapp.Activities.GaleriaActivity;
import com.android.aaronbonilla.infoapp.Activities.HistoriaActivity;
import com.android.aaronbonilla.infoapp.Activities.MapsActivity;
import com.android.aaronbonilla.infoapp.Activities.NoticiasActivity;
import com.android.aaronbonilla.infoapp.Activities.PlanEstudio;
import com.google.firebase.auth.FirebaseAuth;

public class Home_screen extends AppCompatActivity  implements OnClickListener {

    private Button estudio, noticias, galeria, historia, fichas, map;
    Intent i;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen_activity);
        //Declaracion de la orientacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //boton de salida
        Button button = (Button) findViewById(R.id.signout);
        mAuth = FirebaseAuth.getInstance();
            //boton de salida
        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null) {
                    startActivity(new Intent(Home_screen.this, singing_activity.class));
                }
            }
        };

        //boton de salida
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        //botones
        init();
    }

    //Para bloquear botonoes de navegacion
    @Override
    public void onBackPressed(){
    }

    //casteo e inicializacion para cada button, y evento
    public void init(){
        estudio = (Button)findViewById(R.id.estudio);
        estudio.setOnClickListener(this);
        noticias = (Button)findViewById(R.id.noticias);
        noticias.setOnClickListener(this);
        galeria = (Button)findViewById(R.id.galeria);
        galeria.setOnClickListener(this);
        historia = (Button)findViewById(R.id.historia);
        historia.setOnClickListener(this);
        fichas = (Button)findViewById(R.id.fichas);
        fichas.setOnClickListener(this);
        map = (Button)findViewById(R.id.map);
        map.setOnClickListener(this);

    }

    //Eventos para cada ImageButton
    public void onClick(View v){
        int id;
        id=v.getId();
        switch (id){
            case R.id.estudio:
                Intent intents = new Intent(Home_screen.this, PlanEstudio.class);
                startActivity(intents);
                finish();
                break;

            case  R.id.noticias:
                Intent intent1 = new Intent(Home_screen.this, NoticiasActivity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.galeria:
                Intent intent2 = new Intent(Home_screen.this, GaleriaActivity.class);
                startActivity(intent2);
                finish();
                break;

            case R.id.historia:
                Intent intent3 = new Intent(Home_screen.this, HistoriaActivity.class);
                startActivity(intent3);
                finish();
                break;

            case R.id.fichas:
                Intent intent4 = new Intent(Home_screen.this, FichasActivity.class);
                startActivity(intent4);
                finish();
                break;

            case R.id.map:
                Intent intent5 = new Intent(Home_screen.this, MapsActivity.class);
                startActivity(intent5);
                finish();
                break;
        }

    }

}
