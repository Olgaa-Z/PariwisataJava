package com.lauwba.pariwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    CarouselView customCarouselView;
    int[] sampleImages = {R.drawable.ntt1, R.drawable.ntt2, R.drawable.ntt3, R.drawable.ntt4, R.drawable.ntt5};
    String[] sampleTitles = {"Orange", "Grapes", "Strawberry", "Cherry", "Apricot"};

    TextView tvToday;
    String hariIni;

//    CardView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselView.setPageCount(sampleImages.length);
        customCarouselView.setSlideInterval(4000);
        customCarouselView.setViewListener(viewListener);

        tvToday = findViewById(R.id.tvDate);
        //get Time Now
        Date dateNow = Calendar.getInstance().getTime();
        hariIni = (String) DateFormat.format("EEEE", dateNow);
        getToday();

        CardView home = (CardView) findViewById(R.id.home);
        CardView portal = (CardView) findViewById(R.id.portalwisata);
        CardView lokasi = (CardView) findViewById(R.id.lokasiwisata);
        CardView video = (CardView) findViewById(R.id.videowisata);
        CardView galeri = (CardView) findViewById(R.id.galeriwisata);

        CardView tentang = (CardView) findViewById(R.id.tentangwisata);
        //Aksi menu saat diklik
        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BerandaActivity.class);
                startActivity(i);
            }
        });

        portal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,PortalActivity.class);
                startActivity(i);
            }
        });

        lokasi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(i);
            }
        });

        video.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,VideoActivity.class);
                startActivity(i);
            }
        });

        galeri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ImageActivity.class);
                startActivity(i);
            }
        });

        tentang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,TentangActivity.class);
                startActivity(i);
            }
        });


    }

    private void getToday() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d MMMM yyyy", date);
        String formatFix = hariIni + ", " + tanggal;
        tvToday.setText(formatFix);
    }


//    // To set custom views
    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {

            View customView = getLayoutInflater().inflate(R.layout.header, null);
            TextView labelTextView = (TextView) customView.findViewById(R.id.labelTextView);
            ImageView fruitImageView = (ImageView) customView.findViewById(R.id.fruitImageView);
            fruitImageView.setImageResource(sampleImages[position]);
            labelTextView.setText(sampleTitles[position]);
            return customView;
        }
    };

}
