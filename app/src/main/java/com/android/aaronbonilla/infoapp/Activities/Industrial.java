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

public class Industrial extends AppCompatActivity implements View.OnClickListener {

    private TextView objIi, campIi, perIi, planIi, venIi;
    private Button industrialback;
    Intent i;

    //-----------------------------
    //Referencia a Base de DatosFirebase.....
    //-----------------------------
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensaje1 = ref.child("objetivoII");
    DatabaseReference mensaje2 = ref.child("campoII");
    DatabaseReference mensaje3 = ref.child("perfilII");
    DatabaseReference mensaje4 = ref.child("planII");
    DatabaseReference mensaje5 = ref.child("ventajaII");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industrial);

        //-----------------------------
        //Casteo.....
        //-----------------------------
        objIi = (TextView)findViewById(R.id.objii);
        campIi = (TextView)findViewById(R.id.campIi);
        perIi = (TextView)findViewById(R.id.perIi);
        planIi =(TextView)findViewById(R.id.planIi);
        venIi = (TextView)findViewById(R.id.venIi);



        init();

    }
    //bloqueo botones de navegacion
    @Override
    public void onBackPressed(){
    }

    public void init() {
        industrialback = (Button) findViewById(R.id.industrialback);
        industrialback.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.industrialback:
                Intent intents = new Intent(Industrial.this, PlanEstudio.class);
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
                objIi.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                campIi.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                perIi.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                planIi.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                venIi.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
