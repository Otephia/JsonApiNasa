package com.recepaykut.jsonnasaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import static com.recepaykut.jsonnasaproject.TechPortActivity.EXTRA_ID_TECHPORT;
import static com.recepaykut.jsonnasaproject.TechPortActivity.EXTRA_UPDATE_TECHPORT;


public class TechPortDetailActivity  extends AppCompatActivity {

    ArrayList<HashMap<String, String>> itemList;


    private RecyclerView mRecyclerView;
    private TechPortDetailAdapter mTechportDetailAdapter ;
    private ArrayList<TechPortDetaItem> mTechPortDetailList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_port_detail);

        mRecyclerView = findViewById(R.id.recycler_view_tech_port_detail);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTechPortDetailList = new ArrayList<>();

        mRequestQueue =  Volley.newRequestQueue(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra(EXTRA_ID_TECHPORT);


        String url = "https://api.nasa.gov/techport/api/projects/"+id+"?api_key=1MrkZL0qZAChQKc5olEeiKQOZtZTjzOImdPd90lL";

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                        JSONObject projects = response.getJSONObject("project");
                        String title = projects.getString("title");
                        String status = projects.getString("status");
                        String startDate = projects.getString("startDate");
                        String endDate = projects.getString("endDate");
                        String description = projects.getString("description");
                        String id = projects.getString("id");

                    mTechPortDetailList.add(new TechPortDetaItem(title, status, startDate, endDate, description, id));
                    mTechportDetailAdapter = new TechPortDetailAdapter(TechPortDetailActivity.this, mTechPortDetailList);
                    mRecyclerView.setAdapter(mTechportDetailAdapter);

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




/** Intent intent = getIntent();
 String id = intent.getStringExtra(EXTRA_ID);
 String lastUpdate = intent.getStringExtra(EXTRA_LAST_UPDATE);


 TextView mTitle = findViewById(R.id.title_tech_port);
 TextView mStatus = findViewById(R.id.statu_detail_mars);
 TextView mStartDate = findViewById(R.id.startDate_tech_port);
 TextView mEndDate = findViewById(R.id.endDate_tech_port);
 TextView mDescription = findViewById(R.id.description_tech_port);
 TextView mId = findViewById(R.id.id_tech_port);
 TextView mLastUpdate = findViewById(R.id.lastUpdate_tech_port);

 mId.setText("Project ID: " + id);
 mLastUpdate.setText("Last Update: " + lastUpdate);**/

    /**String urlDetay = "https://api.nasa.gov/techport/api/projects/"+cItem.getId()+"?api_key=1MrkZL0qZAChQKc5olEeiKQOZtZTjzOImdPd90lL";
     final JsonObjectRequest requestDetay = new JsonObjectRequest(Request.Method.GET, urlDetay, null, new Response.Listener<JSONObject>() {
    @Override
    public void onResponse(JSONObject response) {

    try {
    JSONObject projects = response.getJSONObject("project");

    String title = projects.getString("title");
    String status = projects.getString("status");
    String startDate = projects.getString("startDate");
    String endDate = projects.getString("endDate");
    String description = projects.getString("description");

    mTechPortDetailList.add(new TechPortDetaItem(title, status, startDate, endDate, description));

    } catch (JSONException e) {
    e.printStackTrace();
    }


    }}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
    error.printStackTrace();
    }
    });

     mRequestQueue2.add(requestDetay);

     TechPortDetaItem dItem = mTechPortDetailList.get(position);

     //title, status, startDate, endDate, description
     intentDetay.putExtra(EXTRA_TITLE, dItem.getTitle());
     intentDetay.putExtra(EXTRA_STATUS, dItem.getStatus());
     intentDetay.putExtra(EXTRA_START_DATE, dItem.getStartDate());
     intentDetay.putExtra(EXTRA_END_DATE, dItem.getEndDate());
     intentDetay.putExtra(EXTRA_DESCRIPTION, dItem.getDescription());**/
}
