package com.recepaykut.jsonnasaproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TechPortDetailAdapter extends RecyclerView.Adapter<TechPortDetailAdapter.TechPortDetailViewHolder> {

    private Context mContext;
    private ArrayList<TechPortDetaItem> mTechPortDetailList;


    public TechPortDetailAdapter (Context context, ArrayList<TechPortDetaItem> techPortDetailList){

        mContext = context;
        mTechPortDetailList = techPortDetailList;
    }

    @Override
    public TechPortDetailAdapter.TechPortDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_detail_techport,parent,false);
        return new TechPortDetailAdapter.TechPortDetailViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TechPortDetailAdapter.TechPortDetailViewHolder holder, int position) {
        TechPortDetaItem dItem = mTechPortDetailList.get(position);
//String title, String status, String startDate, String endDate, String description
        String title = dItem.getTitle();
        String status = dItem.getStatus();
        String startDate = dItem.getStartDate();
        String endDate = dItem.getEndDate();
        String description = dItem.getDescription();
        String id = dItem.getId();


        holder.mTitle.setText("Title: " + title);
        holder.mStatus.setText("Status: " + status);
        holder.mStartDate.setText("Start Date: " + startDate);
        holder.mEndDate.setText("End Date: " + endDate);
        holder.mDescription.setText(description);
        holder.mId.setText("Project Id: " + id);
    }



    @Override
    public int getItemCount() {
        return mTechPortDetailList.size();
    }

    public class TechPortDetailViewHolder extends RecyclerView.ViewHolder{
//tring title, String status, String startDate, String endDate, String description
        public TextView mTitle;
        public TextView mStatus;
        public TextView mStartDate;
        public TextView mEndDate;
        public TextView mDescription;
        public TextView mId;

        public TechPortDetailViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title_tech_port);
            mStatus = itemView.findViewById(R.id.status_tech_port);
            mStartDate = itemView.findViewById(R.id.startDate_tech_port);
            mEndDate = itemView.findViewById(R.id.endDate_tech_port);
            mDescription = itemView.findViewById(R.id.description_tech_port);
            mId = itemView.findViewById(R.id.id_tech_port_detail);

        }
    }

}

