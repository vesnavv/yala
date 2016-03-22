package com.example.atg.yalantisfirst;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    private ArrayList <Uri> mPictures;
    private Context context;
    private RecyclerViewOnClickListener mListener;

    public MyAdapter(Context context, ArrayList<Uri> mPictures, RecyclerViewOnClickListener mListener) {
        this.context = context;
        this.mPictures = mPictures;
        this.mListener = mListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, final int position) {
        ViewHolder holder = (ViewHolder)h;

        Picasso.with(context)
                .load(mPictures.get(position))
                .resize(400, 400)
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onImageClick("ImageView " + position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPictures.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
