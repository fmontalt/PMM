package come.example.fraleo.examen_ev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
    ArrayList<Pizzas> lista;
    private Object Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spinner = (Spinner) findViewById(R.id.spinner);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radioLocal = (RadioButton) findViewById(R.id.local);
        final RadioButton radioDomicilio = (RadioButton) findViewById(R.id.domicilio);
        final CheckBox checkboxTamanyo = (CheckBox) findViewById(R.id.tamanyo);
        final CheckBox checkboxIngredientes = (CheckBox)findViewById(R.id.ingrediente);
        final CheckBox checkboxQueso = (CheckBox) findViewById(R.id.queso);
        final EditText unidades_edit = (EditText) findViewById(R.id.unidades);
        Button boton = (Button) findViewById(R.id.boton);
        cargaSpinner();
        final Spinner spinner_cargado = (Spinner)findViewById(R.id.spinner);

        bundle = new Bundle();



        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.local:
                        bundle.putString("envio", "local");
                        bundle.putDouble("extra_envio",1);
                        break;
                    case R.id.domicilio:
                        bundle.putString("envio", "domicilio");
                        bundle.putDouble("extra_envio",1.10);
                        break;
                }

                bundle.putSerializable("infoObject",(Pizzas)lista.toArray()[spinner_cargado.getSelectedItemPosition()]);

                if(checkboxTamanyo.isChecked()){
                    bundle.putString("tamanyo","Tamaño grande");
                    bundle.putInt("extra_tamanyo",1);
                }else {
                    bundle.putString("tamanyo","Tamaño normal");
                    bundle.putInt("extra_tamanyo",0);
                }

                if(checkboxIngredientes.isChecked()){
                    bundle.putString("ingrediente","Mas ingredientes");
                    bundle.putInt("extra_ingrediente",1);
                }else {
                    bundle.putString("ingrediente","Sin ingredientes extra");
                    bundle.putInt("extra_ingrediente",0);
                }

                if(checkboxQueso.isChecked()){
                    bundle.putString("queso","Mas queso");
                    bundle.putInt("extra_queso",1);
                }else {
                    bundle.putString("queso","Sin mas queso");
                    bundle.putInt("extra_queso",0);
                }


                if(unidades_edit.getText().toString().equals("")){
                    unidades_edit.setText("1");
                }

                bundle.putInt("unidades",Integer.parseInt(unidades_edit.getText().toString()));

                Intent mIntent = new Intent(MainActivity.this, Recibo_pizza.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);


            }
        });
    }



    private void cargaSpinner(){
        lista = new ArrayList <Pizzas>();
        lista.add(new Pizzas("Normal", "Jamon york, Queso", 15,R.drawable.pizza1));
        lista.add(new Pizzas("Barbacoa", "Cebolla, Carne picada...", 30,R.drawable.pizza2));
        lista.add(new Pizzas("Margarita", "Queso, Salami", 20,R.drawable.pizza3));
        lista.add(new Pizzas("Vegana", "Tofu, Cosas veganas", 10,R.drawable.pizza4));


        AdaptadorPizzas adaptador = new AdaptadorPizzas(this, lista);

        spinner.setAdapter(adaptador);

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.androidstudiofaqs, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent acerca = new Intent(MainActivity.this, acercade.class);
            startActivity(acerca);
            return true;

        }

        if (id == R.id.dibujo) {


        }

        return super.onOptionsItemSelected(item);
    }



}
