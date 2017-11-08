package com.example.fraleo.lista;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final TextView texto1 = (TextView) findViewById(R.id.texto1);
        final String[] datos =
                new String[]{"Elem1", "Elem2", "Elem3", "Elem4", "Elem5"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);
    }

}