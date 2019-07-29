package com.android.aaronbonilla.infoapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.aaronbonilla.infoapp.Home_screen;
import com.android.aaronbonilla.infoapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.View.OnClickListener;
import android.widget.TextView;


public class FichasActivity extends AppCompatActivity  implements OnClickListener {

    private TextView msgContactanos;
    private Button fichasback;
    Intent i;

    //-----------------------------
    //Referencia a Base de DatosFirebase.....
    //-----------------------------
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensaje1 = ref.child("smsContactanos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas);

        //Declaracion de la orientacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //-----------------------------
        //Casteo.....
        //-----------------------------
        msgContactanos = (TextView)findViewById(R.id.msgContactanos);

        //botones
        init();


    }
    //Para bloquear botonoes de navegacion deja en blanco
       @Override
       public void onBackPressed(){
       }

    public void init() {
        fichasback = (Button) findViewById(R.id.fichasback);
        fichasback.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.fichasback:
                Intent intents = new Intent(FichasActivity.this, Home_screen.class);
                startActivity(intents);
                finish();
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Bloque de codigo para hacer refrencia al el texto a Firebase....
        mensaje1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                msgContactanos.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
