package com.recepaykut.jsonnasaproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.NasaViewHolder> {

    private Context mContext;
    private ArrayList<NasaItem> mNasaList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public NasaAdapter (Context context, ArrayList<NasaItem> nasaList){

        mContext = context;
        mNasaList = nasaList;
    }

    @Override
    public NasaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_loginscreen,parent,false);
        return new NasaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NasaViewHolder holder, int position) {
        NasaItem nItem = mNasaList.get(position);

        String resimUrl = nItem.getResimUrl();
        String aciklama = nItem.getAciklama();
        String tarih = nItem.getTarih();
        String detay = nItem.getDetay();

        holder.mAciklama.setText(aciklama);
        Picasso.with(mContext).load(resimUrl).fit().centerInside().into(holder.mResim);
        holder.mTarih.setText("Date: " + tarih);
    }

    @Override
    public int getItemCount() {
        return mNasaList.size();
    }

    public class NasaViewHolder extends RecyclerView.ViewHolder{

        public ImageView mResim;
        public TextView mAciklama;
        public TextView mTarih;

        public NasaViewHolder(View itemView) {
            super(itemView);
            mResim = itemView.findViewById(R.id.gunun_resmi);
            mAciklama = itemView.findViewById(R.id.aciklama);
            mTarih = itemView.findViewById(R.id.tarih);

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
