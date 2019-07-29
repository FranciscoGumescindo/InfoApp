package com.android.aaronbonilla.infoapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.aaronbonilla.infoapp.Home_screen;
import com.android.aaronbonilla.infoapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Gestion extends AppCompatActivity implements View.OnClickListener {

    private TextView objIge, campIge, perIge, planIge, venIge;
    private Button gestionback;
    Intent i;

    //-----------------------------
    //Referencia a Base de DatosFirebase.....
    //-----------------------------
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensaje1 = ref.child("objetivoIGE");
    DatabaseReference mensaje2 = ref.child("campoIGE");
    DatabaseReference mensaje3 = ref.child("perfilIGE");
    DatabaseReference mensaje4 = ref.child("planIGE");
    DatabaseReference mensaje5 = ref.child("ventajaIGE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        //-----------------------------
        //Casteo.....
        //-----------------------------
        objIge = (TextView)findViewById(R.id.objIge);
        campIge = (TextView)findViewById(R.id.campIge);
        perIge = (TextView)findViewById(R.id.perIge);
        planIge =(TextView)findViewById(R.id.planIge);
        venIge = (TextView)findViewById(R.id.venIge);


        //evento
        init();
    }
    //Para bloquear botonoes de navegacion
    @Override
    public void onBackPressed(){
    }

    public void init() {
        gestionback = (Button) findViewById(R.id.gestionback);
        gestionback.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.gestionback:
                Intent intents = new Intent(Gestion.this, PlanEstudio.class);
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
                objIge.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                campIge.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                perIge.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                planIge.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                venIge.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
