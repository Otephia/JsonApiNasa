package com.recepaykut.jsonnasaproject;

public class NasaItem {

    private String mResimUrl;
    private String mAciklama;
    private String  mTarih;
    private String mDetay;

    public NasaItem(String resimUrl, String aciklama, String tarih, String detay ){

        mResimUrl = resimUrl;
        mAciklama = aciklama;
        mTarih = tarih;
        mDetay = detay;
    }

    public String getResimUrl() {
        return mResimUrl;
    }

    public String getAciklama() {
        return mAciklama;
    }

    public String getTarih(){
        return mTarih;
    }

    public String getDetay() {
        return mDetay;
    }


}
