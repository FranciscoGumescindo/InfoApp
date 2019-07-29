package com.android.aaronbonilla.infoapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.aaronbonilla.infoapp.R;
import com.squareup.picasso.Picasso;

//----------------------------------------------------
//Casteo de elementos de layout, para enviar  a clase Noticias_Activity
//----------------------------------------------------
public class ViewHolderNews extends RecyclerView.ViewHolder {

    View mView;
    public ViewHolderNews(View itemView) {
        super(itemView);

        mView = itemView;
    }

    //Casteo, y envio de datos....
    public void setDetails(Context ctx, String titles, String descriptions, String authors, String images){
        TextView mTitle= mView.findViewById(R.id.rTitle);
        TextView mDetail = mView.findViewById(R.id.rDescription);
        TextView mAuthor = mView.findViewById(R.id.rAuthor);
        ImageView mImage = mView.findViewById(R.id.rImage);
        //Enviar los datos a la vista....
        mTitle.setText(titles);
        mDetail.setText(descriptions);
        mAuthor.setText(authors);
        Picasso.get().load(images).into(mImage);
    }
}
