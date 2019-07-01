package com.recepaykut.jsonnasaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.recepaykut.jsonnasaproject.MainActivity.EXTRA_DATE;
import static com.recepaykut.jsonnasaproject.MainActivity.EXTRA_IMAGE;
import static com.recepaykut.jsonnasaproject.MainActivity.EXTRA_TITLE;
import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_FULL_NAME;
import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_IMAGE_MARS;

import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_LANDING_DATE;
import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_LAUNCH_DATE;
import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_PHOTO_ID;
import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_ROVER_NAME;
import static com.recepaykut.jsonnasaproject.MarsActivity.EXTRA_ROVER_STATUS;


public class MarsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars_detail);


        Intent intent = getIntent();
        String date = intent.getStringExtra(MarsActivity.EXTRA_DATE);
        String fullName = intent.getStringExtra(EXTRA_FULL_NAME);
        String imgUrl = intent.getStringExtra(EXTRA_IMAGE_MARS);
        String photoId = intent.getStringExtra(EXTRA_PHOTO_ID);
        String roverName = intent.getStringExtra(EXTRA_ROVER_NAME);
        String roverStatus = intent.getStringExtra(EXTRA_ROVER_STATUS);
        String landingDate = intent.getStringExtra(EXTRA_LANDING_DATE);
        String launchDate = intent.getStringExtra(EXTRA_LAUNCH_DATE);


        TextView mDate = findViewById(R.id.date_detail_mars);
        TextView mFullName = findViewById(R.id.full_name_detail_mars);
        ImageView mImgUrl = findViewById(R.id.image_detail_mars);
        TextView mPhotoId = findViewById(R.id.photo_id_detail_mars);
        TextView mRoverName = findViewById(R.id.rover_name_detail_mars);
        TextView mRoverStatus = findViewById(R.id.statu_detail_mars);
        TextView mLandingDate = findViewById(R.id.landing_date_detail_mars);
        TextView mLaunchDate = findViewById(R.id.launch_date_detail_mars);

        Picasso.with(this).load(imgUrl).fit().centerInside().into(mImgUrl);
        mDate.setText("Date: " + date);
        mPhotoId.setText("Photo Id: " + photoId);
        mFullName.setText("Name: " + fullName);
        mRoverName.setText("Rover Name: " + roverName);
        mRoverStatus.setText("Status: " + roverStatus);
        mLandingDate.setText("Landing Date: " + landingDate);
        mLaunchDate.setText("Launch Date: " + launchDate);

    }
}
