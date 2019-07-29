package com.android.aaronbonilla.infoapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.aaronbonilla.infoapp.Home_screen;
import com.android.aaronbonilla.infoapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HistoriaActivity extends AppCompatActivity implements OnClickListener {

    private TextView homeQuien, objGeneral, objEspecificos, justi;

    private Button historiaback;
    Intent i;

    //-----------------------------
    //Referencia a Base de DatosFirebase.....
    //-----------------------------
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensaje1 = ref.child("quienHisto");
    DatabaseReference mensaje2 = ref.child("General");
    DatabaseReference mensaje3 = ref.child("Especifico");
    DatabaseReference mensaje4 = ref.child("Justificacion");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);
        //Declaracion de la orientacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //-----------------------------
        //Casteo.....
        //-----------------------------
        homeQuien = (TextView)findViewById(R.id.homeQuien);
        objGeneral = (TextView)findViewById(R.id.objGeneral);
        objEspecificos = (TextView)findViewById(R.id.objEspecificos);
        justi =(TextView)findViewById(R.id.Justificacion);


        //botones
        init();

    }

    //Para bloquear botonoes de navegacion deja en blanco
    @Override
    public void onBackPressed(){
    }

    public void init() {
        historiaback = (Button) findViewById(R.id.historiaback);
        historiaback.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.historiaback:
                Intent intents = new Intent(HistoriaActivity.this, Home_screen.class);
                startActivity(intents);
                finish();
                break;
        }
    }

    //-----------------------------
    //Referencia a firebase.....
    //-----------------------------

    @Override
    protected void onStart() {
        super.onStart();
        //Bloque de codigo para hacer refrencia al el texto a Firebase....
        mensaje1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                homeQuien.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                objGeneral.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                objEspecificos.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                justi.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


    }

}
