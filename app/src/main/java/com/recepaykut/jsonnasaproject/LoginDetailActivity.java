package com.recepaykut.jsonnasaproject;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.recepaykut.jsonnasaproject.MainActivity.EXTRA_DATE;
import static com.recepaykut.jsonnasaproject.MainActivity.EXTRA_IMAGE;
import static com.recepaykut.jsonnasaproject.MainActivity.EXTRA_TITLE;

public class LoginDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_detail);

        Intent intent = getIntent();
        String resimUrl = intent.getStringExtra(EXTRA_IMAGE);
        String date = intent.getStringExtra(EXTRA_DATE);
        String detay = intent.getStringExtra(EXTRA_TITLE);

        ImageView resimY = findViewById(R.id.image_detail);
        TextView dateY = findViewById(R.id.date);
        TextView detayY = findViewById(R.id.title);

        Picasso.with(this).load(resimUrl).fit().centerInside().into(resimY);
        dateY.setText(date);
        detayY.setText(detay);
    }
}
