package com.recepaykut.jsonnasaproject;

public class MarsItem {

    private String mDate;
    private String mFullName;
    private String  mImgUrl;
    private String mPhotoId;
    private String mRoverName;
    private String mRoverStatus;
    private String mLandingDate;
    private String mLaunchDate;


    public MarsItem(String date, String fullName, String imgUrl, String photoId, String roverName, String roverStatus, String landingDate, String launchDate ){
        this.mDate = date;
        this.mFullName = fullName;
        this.mImgUrl = imgUrl;
        this.mPhotoId = photoId;
        this.mRoverName = roverName;
        this.mRoverStatus = roverStatus;
        this.mLandingDate = landingDate;
        this.mLaunchDate = launchDate;



    }

    public String getDate() {
        return mDate;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getImgUrl() {
        return mImgUrl;
    }

    public String getPhotoId() {
        return mPhotoId;
    }

    public String getRoverName() {
        return mRoverName;
    }

    public String getRoverStatus() {
        return mRoverStatus;
    }

    public String getLandingDate() {
        return mLandingDate;
    }

    public String getLaunchDate() {
        return mLaunchDate;
    }
}
