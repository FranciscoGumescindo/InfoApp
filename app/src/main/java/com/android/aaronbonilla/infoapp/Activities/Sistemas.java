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

public class Sistemas extends AppCompatActivity implements View.OnClickListener {

    private TextView objisc, campisc, perIsc, planIsc, venIsc;
    private Button sistemasback;
    Intent i;

    //-----------------------------
    //Referencia a Base de DatosFirebase.....
    //-----------------------------
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensaje1 = ref.child("objetivoISC");
    DatabaseReference mensaje2 = ref.child("campoISC");
    DatabaseReference mensaje3 = ref.child("perfilISC");
    DatabaseReference mensaje4 = ref.child("planISC");
    DatabaseReference mensaje5 = ref.child("ventajaISC");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistemas);

        //-----------------------------
        //Casteo.....
        //-----------------------------
        objisc = (TextView)findViewById(R.id.objisc);
        campisc = (TextView)findViewById(R.id.campisc);
        perIsc = (TextView)findViewById(R.id.perIsc);
        planIsc =(TextView)findViewById(R.id.planIsc);
        venIsc = (TextView)findViewById(R.id.venIsc);

        init();
    }

    //bloqueo de boton atras
    @Override
    public void onBackPressed(){
    }


    public void init() {
        sistemasback = (Button) findViewById(R.id.sistemasback);
        sistemasback.setOnClickListener(this);
    }

    //-----------------------------
    //Eventos para cada button.....
    //-----------------------------
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.sistemasback:
                Intent intents = new Intent(Sistemas.this, PlanEstudio.class);
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
                objisc.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                campisc.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                perIsc.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                planIsc.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        mensaje5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value2 = dataSnapshot.getValue(String.class);
                venIsc.setText(value2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

}
