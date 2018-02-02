package come.example.fraleo.examen_ev1;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextView;

public class Recibo_pizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo_pizza);

        final TextView info_pizza = (TextView) findViewById(R.id.info_pizza);
        final TextView info_precio = (TextView) findViewById(R.id.info_precio);
        final TextView info_extra = (TextView) findViewById(R.id.info_extra);
        final TextView info_unidades = (TextView) findViewById(R.id.info_unidades);
        final TextView info_envio = (TextView) findViewById(R.id.info_envio);
        final TextView info_coste_final = (TextView) findViewById(R.id.info_coste_final);
        final CheckBox checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen);
        final DigitalClock clock = (DigitalClock) findViewById(R.id.reloj);

        Intent intent = getIntent();

        Pizzas info_res = (Pizzas) intent.getSerializableExtra("infoObject");

        String envio = intent.getStringExtra("envio");
        double extra_envio = intent.getDoubleExtra("extra_envio",1.10);

        int unidades = intent.getIntExtra("unidades",0);

        String tamanyo = intent.getStringExtra("tamanyo");
        int extra_tamanyo = intent.getIntExtra("extra_tamanyo",0);

        String ingrediente = intent.getStringExtra("ingrediente");
        int extra_ingrediente = intent.getIntExtra("extra_ingrediente",0);

        String queso = intent.getStringExtra("queso");
        int extra_queso = intent.getIntExtra("extra_queso",0);


        info_pizza.setText("Pizza: "+info_res.getNombre());
        info_precio.setText("Precio Base: "+info_res.getPrecio());
        int suma_extra = (int) (extra_envio+extra_ingrediente+extra_queso);
        int precio_aux = info_res.getPrecio();
        info_extra.setText("Extra: "+String.valueOf(suma_extra)+"€");
        info_unidades.setText("Unidades: "+unidades);
        info_envio.setText("Envio: "+envio);
        imagen.setImageResource(info_res.getImagen());
        info_coste_final.setText("Coste final: "+(((precio_aux+suma_extra)*unidades)*extra_envio)+" €");

        checkbox2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){

                clock.setVisibility(View.VISIBLE);

            }
        });

    }




}
