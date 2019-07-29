package com.android.aaronbonilla.infoapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.aaronbonilla.infoapp.Home_screen;
import com.android.aaronbonilla.infoapp.R;
import com.android.aaronbonilla.infoapp.adapters.ViewHolder;
import com.android.aaronbonilla.infoapp.clases.Model;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import android.view.View.OnClickListener;

public class GaleriaActivity extends AppCompatActivity implements OnClickListener {

    private Button galeriaback;
    Intent i;

    //-----------------------------
    //Declaracion de las variables respecto a la galeria...
    //-----------------------------
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    private Button backGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        //Declaracion de la orientacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //-----------------------------
        //Casteo de las variables para el uso de la galeria
        //-----------------------------
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Crreacion de variable y referencia a base de datos en Firebase...
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef= mFirebaseDatabase.getReference("Data");
        //Metodo para el boton de salida...

        //botones
        init();

    }
    //Para bloquear botonoes de navegacion
     @Override
     public void onBackPressed(){
     }

    public void init() {
        galeriaback = (Button) findViewById(R.id.galeriaback);
        galeriaback.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.galeriaback:
                Intent intents = new Intent(GaleriaActivity.this, Home_screen.class);
                startActivity(intents);
                finish();
                break;
        }
    }

    //-----------------------------
    //Galeria, llamado de ViewHolder y Model y sus datos
    //-----------------------------
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getDescription(),model.getImage());


                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
