package com.recepaykut.jsonnasaproject;

public class TechPortDetaItem {

   // (title, status, startDate, endDate,destinations)

    private String mTitle;
    private String mStatus;
    private String mStartDate;
    private String mEndDate;
    private String mDescription;
    private String mId;


    public TechPortDetaItem(String title, String status, String startDate, String endDate, String description, String id ){

        this.mTitle = title;
        this.mStatus = status;
        this.mStartDate = startDate;
        this.mEndDate = endDate;
        this.mDescription = description;
        this.mId = id;

    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getStatus() {
        return mStatus;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public String getDescription() {
        return mDescription;
    }
}
