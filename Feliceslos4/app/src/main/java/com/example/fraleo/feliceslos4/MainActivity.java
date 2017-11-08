package com.example.fraleo.feliceslos4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button cmdLinear = (Button) findViewById(R.id.cmdLinear);
        final Button cmdTabla = (Button) findViewById(R.id.cmdTabla);
        final Button cmdRelativo = (Button) findViewById(R.id.cmdRelativo);
        final Button cmdGrid = (Button) findViewById(R.id.cmdGrid);
        final Button cmdCheck = (Button) findViewById(R.id.cmdCheck);
        final Button cmdRadio = (Button) findViewById(R.id.cmdRadio);

        cmdLinear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(miIntent);
            }
        });
        cmdTabla.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(miIntent);
            }
        });
        cmdRelativo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(miIntent);
            }
        });
        cmdRelativo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, Main5Activity.class);
                startActivity(miIntent);
            }
        });
        cmdCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, check.class);
                startActivity(miIntent);
            }
        });
    }
}
