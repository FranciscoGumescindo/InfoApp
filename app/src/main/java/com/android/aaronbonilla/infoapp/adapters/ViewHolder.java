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
public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;
    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }

    //Casteo, y envio de datos....
    public void setDetails(Context ctx, String title, String description, String image){
        TextView mTitleTv= mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageIv = mView.findViewById(R.id.rImageView);
        //Enviar los datos a la vista....
        mTitleTv.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageIv);
    }

}
