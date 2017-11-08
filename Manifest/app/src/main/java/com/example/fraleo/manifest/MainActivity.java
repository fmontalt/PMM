package com.example.fraleo.manifest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button boton = (Button) findViewById(R.id.boton);
        MediaPlayer miMusica= MediaPlayer.create(getApplicationContext(),R.raw.dragonmiedo);
        miMusica.start();

        boton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(miIntent);
            }
        });
    }

}
