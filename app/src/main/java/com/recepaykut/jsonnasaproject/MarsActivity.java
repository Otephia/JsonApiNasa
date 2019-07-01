package com.recepaykut.jsonnasaproject;

import android.app.backup.FullBackupDataOutput;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MarsActivity extends AppCompatActivity implements MarsAdapter.OnItemClickListener {

    public static final String EXTRA_FULL_NAME = "fullName";
    public static final String EXTRA_DATE ="date";
    public static final String EXTRA_IMAGE_MARS = "imgUrl";
    public static final String EXTRA_PHOTO_ID = "fotoID";
    public static final String EXTRA_ROVER_NAME = "roverName";
    public static final String EXTRA_ROVER_STATUS = "roverStatus";
    public static final String EXTRA_LANDING_DATE = "landingDate";
    public static final String EXTRA_LAUNCH_DATE = "launchDate";


    //String date, String fullName, String imgUrl,
    // String photoId, String roverName, String roverStatus,
    // String landingDate, String launchDate

    ArrayList<HashMap<String, String>> itemList;

    // tarih, tamIsım, resimUrl, fotoId, statu, inisTarihi

    private RecyclerView mRecyclerView;
    private MarsAdapter mMarsAdapter;
    private ArrayList<MarsItem> mMarsList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars);

        mRecyclerView = findViewById(R.id.recycler_view_mars);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMarsList = new ArrayList<>();

        mRequestQueue =  Volley.newRequestQueue(this);
        parseJSON();


    }

    /**try {
     JSONArray jsonArray = response.getJSONArray("hits");

     for (int i = 0; i < jsonArray.length(); i++){

     JSONObject hit = jsonArray.getJSONObject(i);

     String resimUrl = hit.getString("webformatURL");
     String aciklama = hit.getString("tags");
     mNasaList.add(new NasaItem(resimUrl, aciklama));
     }

     mNasaAdapter = new NasaAdapter(MainActivity.this, mNasaList);
     mRecyclerView.setAdapter(mNasaAdapter);


     } catch (JSONException e) {
     e.printStackTrace();
     }**/

    private void parseJSON(){
        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=1MrkZL0qZAChQKc5olEeiKQOZtZTjzOImdPd90lL";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("photos");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject data = jsonArray.getJSONObject(i);
                        String imgUrl = data.getString("img_src");
                        String photoId = data.getString("id");
                        String date = data.getString("earth_date");


                        JSONObject cameras = data.getJSONObject("camera");
                        String fullName = cameras.getString("full_name");


                        JSONObject rover = data.getJSONObject("rover");
                        String roverName = rover.getString("name");
                        String roverStatus = rover.getString("status");
                        String roverLandingDate = rover.getString("landing_date");
                        String roverLaunchDate = rover.getString("launch_date");

                        //String date, String fullName, String imgUrl,
                        // String photoId, String roverName, String roverStatus,
                        // String landingDate, String launchDate

                        mMarsList.add(new MarsItem(date, fullName, imgUrl, photoId, roverName, roverStatus, roverLandingDate, roverLaunchDate));

                        }
                        mMarsAdapter = new MarsAdapter(MarsActivity.this, mMarsList);
                        mRecyclerView.setAdapter(mMarsAdapter);
                        mMarsAdapter.setOnItemClickListener(MarsActivity.this);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

    }

    @Override
    public void onItemClick(int position) {
        Intent intentDetay = new Intent(this, MarsDetailActivity.class);
        MarsItem cItem = mMarsList.get(position);

        //String date, String fullName, String imgUrl,
        // String photoId, String roverName, String roverStatus,
        // String landingDate, String launchDate

        intentDetay.putExtra(EXTRA_DATE, cItem.getDate());
        intentDetay.putExtra(EXTRA_FULL_NAME,cItem.getFullName());
        intentDetay.putExtra(EXTRA_IMAGE_MARS, cItem.getImgUrl());
        intentDetay.putExtra(EXTRA_PHOTO_ID,cItem.getPhotoId());
        intentDetay.putExtra(EXTRA_ROVER_NAME,cItem.getRoverName());
        intentDetay.putExtra(EXTRA_ROVER_STATUS,cItem.getRoverStatus());
        intentDetay.putExtra(EXTRA_LANDING_DATE,cItem.getLandingDate());
        intentDetay.putExtra(EXTRA_LAUNCH_DATE,cItem.getLaunchDate());

        startActivity(intentDetay);
    }
}
