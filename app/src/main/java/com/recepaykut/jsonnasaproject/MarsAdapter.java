package com.recepaykut.jsonnasaproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MarsAdapter extends RecyclerView.Adapter<MarsAdapter.MarsViewHolder> {

private Context mContext;
private ArrayList<MarsItem> mMarsList;
private OnItemClickListener mListener;

public interface OnItemClickListener{
    void onItemClick(int position);
}

    public void setOnItemClickListener(MarsAdapter.OnItemClickListener listener){
        mListener = listener;
    }

    public MarsAdapter (Context context, ArrayList<MarsItem> marsList){

        mContext = context;
        mMarsList = marsList;
    }

    @Override
    public MarsAdapter.MarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_mars,parent,false);
        return new MarsAdapter.MarsViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MarsAdapter.MarsViewHolder holder, int position) {
        MarsItem nItem = mMarsList.get(position);


        //String date, String fullName, String imgUrl,
        // String photoId, String roverName, String roverStatus,
        // String landingDate, String launchDate
        String date = nItem.getDate();
        String fullName = nItem.getFullName();
        String imgUrl = nItem.getImgUrl();
        String photoId = nItem.getPhotoId();
        String roverName = nItem.getRoverName();
        String roverStatus = nItem.getRoverStatus();
        String landingDate = nItem.getLandingDate();
        String launchDate = nItem.getLaunchDate();


        holder.mPhotoId.setText("Photo ID: " + photoId);
        Picasso.with(mContext).load(imgUrl).fit().centerInside().into(holder.mImg);
        holder.mDate.setText("Date: " + date);
        holder.mFullName.setText("Full Name: " + fullName);
    }

    @Override
    public int getItemCount() {
        return mMarsList.size();
    }

public class MarsViewHolder extends RecyclerView.ViewHolder{


    //String date, String fullName, String imgUrl,
    // String photoId, String roverName, String roverStatus,
    // String landingDate, String launchDate
    public TextView mDate;
    public TextView mPhotoId;
    public ImageView mImg;
    public TextView mFullName;


    public MarsViewHolder(View itemView) {
        super(itemView);
        mImg = itemView.findViewById(R.id.image_mars);
        mPhotoId = itemView.findViewById(R.id.photo_id);
        mDate = itemView.findViewById(R.id.earth_date);
        mFullName = itemView.findViewById(R.id.full_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            }
        });
    }
}

}
