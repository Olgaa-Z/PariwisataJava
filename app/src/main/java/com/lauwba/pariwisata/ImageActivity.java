package com.lauwba.pariwisata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class ImageActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        GridView gridView = (GridView) findViewById(R.id.gridview_followed);
        gridView.setAdapter(new ImageAdapter (this));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        // TODO Auto-generated method stub
        Toast.makeText(ImageActivity.this, "Klik di"+position, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, SingleImage.class);
        Bundle b = new Bundle();
        b.putInt("posisi", position);
        i.putExtras(b);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
    }
}
