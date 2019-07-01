package com.recepaykut.jsonnasaproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NasaHomePageActivity extends AppCompatActivity {

    ListView list;
    String header[] = {"ASTEROID","EPIC","MARS","TechPort"};
    String content[] = {"A small rocky body orbiting the sun.","Earth Polychromatic Imaging Camera","Mars is a planet. It is the fourth planet from the sun.","Technology Portfolio System for the National Aeronautics and Space Administration"};
    int logo [] = {R.drawable.telescope64, R.drawable.worldwide64, R.drawable.mars64, R.drawable.nasa64};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasa_home_page);

        list = findViewById(R.id.list);

        MyAdapter adapter = new MyAdapter(this, header,logo,content);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){

                    Intent intent = new Intent(NasaHomePageActivity.this, AsteroidActivity.class);
                    startActivity(intent);

                    Toast.makeText(NasaHomePageActivity.this,"Welcome to Asteroid", Toast.LENGTH_SHORT).show();

                }
                if (position == 1){

                    Intent intent = new Intent(NasaHomePageActivity.this, EpicActivity.class);
                    startActivity(intent);

                    Toast.makeText(NasaHomePageActivity.this,"Welcome to Epic", Toast.LENGTH_SHORT).show();
                }

                if (position == 2){

                    Intent intent = new Intent(NasaHomePageActivity.this, MarsActivity.class);
                    startActivity(intent);

                    Toast.makeText(NasaHomePageActivity.this,"Welcome to Mars", Toast.LENGTH_SHORT).show();

                }

                if (position == 3){

                    Intent intent = new Intent(NasaHomePageActivity.this, TechPortActivity.class);
                    startActivity(intent);

                    Toast.makeText(NasaHomePageActivity.this,"Welcome to TechPort", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String bHeader[];
        String bContent[];
        int[] bLogo;

        MyAdapter(Context c, String[] header, int[] resim, String[] content){
            super(c, R.layout.home_items, R.id.list_ad, header);
            this.context = c;
            this.bHeader = header;
            this.bLogo = resim;
            this.bContent = content;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View homeItems = layoutInflater.inflate(R.layout.home_items,parent,false);
            ImageView images = homeItems.findViewById(R.id.logo);
            TextView head = homeItems.findViewById(R.id.list_ad);
            TextView content = homeItems.findViewById(R.id.list_aciklama);
            images.setImageResource(logo[position]);
            head.setText(bHeader[position]);
            content.setText(bContent[position]);


            return homeItems;
        }
    }
}
