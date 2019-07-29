package com.android.aaronbonilla.infoapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.aaronbonilla.infoapp.Home_screen;
import com.android.aaronbonilla.infoapp.R;
import com.android.aaronbonilla.infoapp.adapters.ViewHolder;
import com.android.aaronbonilla.infoapp.adapters.ViewHolderNews;
import com.android.aaronbonilla.infoapp.clases.Model;
import com.android.aaronbonilla.infoapp.clases.ModelNews;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.view.View.OnClickListener;
import android.widget.Button;

public class NoticiasActivity extends AppCompatActivity implements View.OnClickListener {
    private Button noticiasback;
    Intent i;

    //-----------------------------
    //Declaracion de las variables respecto a la galeria...
    //-----------------------------
    RecyclerView mRecyclerView1;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        //Declaracion de la orientacion de la pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //-----------------------------
        //Casteo de las variables para el uso de la galeria
        //-----------------------------
        mRecyclerView1 = findViewById(R.id.recyclerView1);
        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        //Crreacion de variable y referencia a base de datos en Firebase...
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef= mFirebaseDatabase.getReference("Data2");

        //botones
        init();

    }
    //Para bloquear botonoes de navegacion deja en blanco
    @Override
    public void onBackPressed(){
   }

    public void init() {
        noticiasback = (Button) findViewById(R.id.noticiasback);
        noticiasback.setOnClickListener(this);
    }

    //Eventos para cada Button
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id) {
            case R.id.noticiasback:
                Intent intents = new Intent(NoticiasActivity.this, Home_screen.class);
                startActivity(intents);
                finish();
                break;
        }
    }

    //-----------------------------
    //Galeria, implementacion de ViewHolderNews, ModelNews y datos, haciendo
    //referencia a nodo de base de datos en Firebase
    //-----------------------------
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseRecyclerAdapter<ModelNews, ViewHolderNews> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ModelNews, ViewHolderNews>(
                        ModelNews.class,
                        R.layout.rownews,
                        ViewHolderNews.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolderNews viewHolder, ModelNews model, int position) {

                        viewHolder.setDetails(getApplicationContext(),model.getTitles(),model.getDescriptions(),model.getAuthors(),model.getImages());


                    }
                };
        mRecyclerView1.setAdapter(firebaseRecyclerAdapter);
    }

}
