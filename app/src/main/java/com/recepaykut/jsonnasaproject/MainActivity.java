package com.recepaykut.jsonnasaproject;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NasaAdapter.OnItemClickListener {

    public static final String EXTRA_IMAGE = "resimUrl";
    public static final String EXTRA_DATE ="tarih";
    public static final String EXTRA_TITLE = "detay";



    private RecyclerView mRecyclerView;
    private NasaAdapter mNasaAdapter;
    private ArrayList<NasaItem> mNasaList;
    private RequestQueue mRequestQueue;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnHome);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mNasaList = new ArrayList<>();

        mRequestQueue =  Volley.newRequestQueue(this);
        parseJSON();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NasaHomePageActivity.class);
                startActivity(i);
            }
        });


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
        String url = "https://api.nasa.gov/planetary/apod?api_key=1MrkZL0qZAChQKc5olEeiKQOZtZTjzOImdPd90lL";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String resimUrl = response.getString("url");
                    String aciklama = response.getString("title");;
                    String tarih = response.getString("date");
                    String detay = response.getString("explanation");

                    mNasaList.add(new NasaItem(resimUrl, aciklama, tarih, detay));

                    mNasaAdapter = new NasaAdapter(MainActivity.this, mNasaList);
                    mRecyclerView.setAdapter(mNasaAdapter);
                    mNasaAdapter.setOnItemClickListener(MainActivity.this);
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
        Intent intentDetay = new Intent(this, LoginDetailActivity.class);
        NasaItem cItem = mNasaList.get(position);

        intentDetay.putExtra(EXTRA_IMAGE, cItem.getResimUrl());
        intentDetay.putExtra(EXTRA_DATE, cItem.getTarih());
        intentDetay.putExtra(EXTRA_TITLE,cItem.getDetay());

        startActivity(intentDetay);
    }
}
