package com.mazter707.appreferences;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class Visor extends AppCompatActivity {

    private static final String PROPERTY_ID = "";
    public static int GENERAL_TRACKER = 0;

    public enum TrackerName {
        APP_TRACKER, // Tracker used only in this app
        GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg. roll-up tracking.
        ECOMMERCE_TRACKER, // Tracker used by all ecommerce transactions from a company.
    }



    String url_imagen;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        String names = getIntent().getStringExtra("NAME");
        TextView user_name=(TextView)findViewById(R.id.text_name);
        user_name.setText(names);

        url_imagen = getIntent().getStringExtra("PHOTO");
        image=(ImageView)findViewById(R.id.imageName);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "AUN   NO   ME   PROGRAMAN    !!! ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DownloadImage m = new DownloadImage();
        m.execute();
    }




    class  DownloadImage extends AsyncTask<Void, Void, Void>{

        Bitmap download = null;
        @Override
        protected Void doInBackground(Void... params) {

            try {
                download= Picasso.with(Visor.this).load(url_imagen).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {

            if(download != null) {
                image.setImageBitmap(download);
            }
            super.onPostExecute(aVoid);
        }
    }

}
