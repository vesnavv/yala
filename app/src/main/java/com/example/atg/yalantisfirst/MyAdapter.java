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

public class MyAdapter extends RecyclerView.Adapter { //[Comment] Your adapter? Use more informative class names

    private ArrayList <Uri> mPictures; //[Comment] Use abstraction instead of realization
    private Context context; //[Comment] Wrong name, use google
    private RecyclerViewOnClickListener mListener;

    public MyAdapter(Context context, ArrayList<Uri> mPictures, RecyclerViewOnClickListener mListener) {
        this.context = context;
        this.mPictures = mPictures;
        this.mListener = mListener; //[Comment] without this
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_image,parent,false); //[Comment] Wrong formatting
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, final int position) {
        ViewHolder holder = (ViewHolder)h;

        Picasso.with(context)
                .load(mPictures.get(position))
                .resize(400, 400) //[Comment] Magic numbers
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onImageClick("ImageView " + position); //[Comment] Hardcode
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPictures.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView; //[Comment] Wrong visibility modifier
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
