package com.recepaykut.jsonnasaproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class TechPortAdapter extends RecyclerView.Adapter<TechPortAdapter.TechPortViewHolder> {

    private Context mContext;
    private ArrayList<TechPortItem> mTechPortList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(TechPortAdapter.OnItemClickListener listener){
        mListener = listener;
    }

    public TechPortAdapter (Context context, ArrayList<TechPortItem> techPortList){

        mContext = context;
        mTechPortList = techPortList;
    }

    @Override
    public TechPortAdapter.TechPortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_techport,parent,false);
        return new TechPortAdapter.TechPortViewHolder(v);
    }


    @Override
    public void onBindViewHolder(TechPortAdapter.TechPortViewHolder holder, int position) {
        TechPortItem nItem = mTechPortList.get(position);

        String id = nItem.getId();
        String lastUpdate = nItem.getLastUpdate();

        holder.mId.setText("ID: " + id);
        holder.mLastUpdate.setText("Date: " + lastUpdate);

    }

    @Override
    public int getItemCount() {
        return mTechPortList.size();
    }

    public class TechPortViewHolder extends RecyclerView.ViewHolder{

        public TextView mId;
        public TextView mLastUpdate;

        public TechPortViewHolder(View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.techport1);
            mLastUpdate = itemView.findViewById(R.id.techport2);

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
