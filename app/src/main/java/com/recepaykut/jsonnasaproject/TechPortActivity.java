package com.recepaykut.jsonnasaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class TechPortActivity extends AppCompatActivity implements TechPortAdapter.OnItemClickListener {

    public static final String EXTRA_ID_TECHPORT = "id";
    public static final String EXTRA_UPDATE_TECHPORT ="lastUpdate";



    ArrayList<HashMap<String, String>> itemList;

    // tarih, tamIsım, resimUrl, fotoId, statu, inisTarihi

    private RecyclerView mRecyclerView;
    private TechPortAdapter mTechportAdapter ;
    private ArrayList<TechPortItem> mTechPortList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_port);

        mRecyclerView = findViewById(R.id.recycler_view_tech_port);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTechPortList = new ArrayList<>();

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
        String url = "https://api.nasa.gov/techport/api/projects?updatedSince=2019-05-01&api_key=1MrkZL0qZAChQKc5olEeiKQOZtZTjzOImdPd90lL";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject projects = response.getJSONObject("projects");
                    JSONArray jsonArray = projects.getJSONArray("projects");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject data = jsonArray.getJSONObject(i);
                        String id = data.getString("id");
                        String lastUpdate = data.getString("lastUpdated");

                        mTechPortList.add(new TechPortItem(id, lastUpdate));

                    }
                    mTechportAdapter = new TechPortAdapter(TechPortActivity.this, mTechPortList);
                    mRecyclerView.setAdapter(mTechportAdapter);
                    mTechportAdapter.setOnItemClickListener(TechPortActivity.this);


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
        Intent intentDetay = new Intent(this, TechPortDetailActivity.class);
        TechPortItem cItem = mTechPortList.get(position);

        intentDetay.putExtra(EXTRA_ID_TECHPORT, cItem.getId());
        intentDetay.putExtra(EXTRA_UPDATE_TECHPORT, cItem.getLastUpdate());


        startActivity(intentDetay);
    }
}

