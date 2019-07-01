package com.recepaykut.jsonnasaproject;

public class TechPortItem {

    private String mId;
    private String mLastUpdate;

    public TechPortItem(String id, String lastUpdate ){

        mId = id;
        mLastUpdate = lastUpdate;
    }

    public String getId() {
        return mId;
    }

    public String getLastUpdate() {
        return mLastUpdate;
    }
}
