package come.example.fraleo.ejerrecopilatorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Bundle bundle;
    ArrayList<ZonasEnvio> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radioButton_normal = (RadioButton) findViewById(R.id.tarifa_normal);
        final RadioButton radioButton_urgente = (RadioButton) findViewById(R.id.tarifa_urgente);
        final CheckBox checkbox_caja = (CheckBox) findViewById(R.id.caja);
        final CheckBox checkbox_dedicatoria = (CheckBox)findViewById(R.id.dedicatoria);
        final EditText peso_edit = (EditText) findViewById(R.id.peso);
        Button boton = (Button) findViewById(R.id.boton);
        cargaSpinner();
        final Spinner spinner_cargado = (Spinner)findViewById(R.id.spinner);

        bundle = new Bundle();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.tarifa_normal:
                        bundle.putDouble("tarifa", 0.3);
                        break;
                    case R.id.tarifa_urgente:
                        bundle.putDouble("tarifa", 0.6);
                        break;
                }

                bundle.putSerializable("infoObject",(ZonasEnvio)lista.toArray()[spinner_cargado.getSelectedItemPosition()]);

                if(checkbox_caja.isChecked()){
                    bundle.putString("caja","Con caja regalo");
                }else {
                    bundle.putString("caja","");
                }

                if(checkbox_dedicatoria.isChecked()){
                    bundle.putString("dedicatoria","Con dedicatoria");
                }else {
                    bundle.putString("dedicatoria","");
                }

                if(peso_edit.getText().toString().equals("")){
                    peso_edit.setText("1");
                }

                bundle.putInt("peso",Integer.parseInt(peso_edit.getText().toString()));

                Intent mIntent = new Intent(MainActivity.this, Envio_paquete.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);


            }
        });
    }



    private void cargaSpinner(){
         lista = new ArrayList <ZonasEnvio>();
        lista.add(new ZonasEnvio("a", "Asia y Oceanía", 30));
        lista.add(new ZonasEnvio("b", "América y África", 20));
        lista.add(new ZonasEnvio("c", "Europa", 10));


       /// ArrayAdapter<ZonasEnvio> adapter = new ArrayAdapter<ZonasEnvio>(this,
          ///      android.R.layout.simple_spinner_dropdown_item,lista);


        AdaptadorZonas adaptador = new AdaptadorZonas(this, lista);

        spinner.setAdapter(adaptador);
    }
}
