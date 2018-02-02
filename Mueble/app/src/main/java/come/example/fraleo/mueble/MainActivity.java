package come.example.fraleo.mueble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Bundle bundle;
    ArrayList<Mueble> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        cargaSpinner();
        final Spinner spinner_cargado = (Spinner)findViewById(R.id.spinner);

        bundle = new Bundle();

    }

    private void cargaSpinner(){
        lista = new ArrayList <Mueble>();
        lista.add(new Mueble("Normal", "Jamon york, Queso", 15,R.drawable.mue1));
        lista.add(new Mueble("Barbacoa", "Cebolla, Carne picada...", 30,R.drawable.mue2));
        lista.add(new Mueble("Margarita", "Queso, Salami", 20,R.drawable.mue3));
        lista.add(new Mueble("Vegana", "Tofu, Cosas veganas", 10,R.drawable.mue4));


        AdaptadorMueble adaptador = new AdaptadorMueble(this, lista);

        spinner.setAdapter(adaptador);

    }
}
