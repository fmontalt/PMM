package come.example.fraleo.ejerrecopilatorio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Envio_paquete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_paquete);
        final TextView info_view = (TextView) findViewById(R.id.info_prin);
        final TextView info_tarifa = (TextView) findViewById(R.id.info_tarifa);
        final TextView info_peso = (TextView) findViewById(R.id.info_peso);
        final TextView info_decoracion = (TextView) findViewById(R.id.info_decoracion);
        final TextView info_coste_final = (TextView) findViewById(R.id.info_coste_final);

        Intent intent = getIntent();

        ZonasEnvio info_res = (ZonasEnvio) intent.getSerializableExtra("infoObject");
        double tarifa = intent.getDoubleExtra("tarifa",0.6);
        int peso = intent.getIntExtra("peso",0);
        String caja = intent.getStringExtra("caja");
        String decoracion = intent.getStringExtra("dedicatoria");




        info_view.setText("Zona: "+info_res.getZona()+" "+info_res.getNombre());

        String tipo_tarifa="";

        if (tarifa== 0.3){
            tipo_tarifa = "Normal";
        }else{
            tipo_tarifa = "Urgente";
        }
        info_tarifa.setText("Tipo tarifa: "+tipo_tarifa);
        info_peso.setText("Peso: "+peso);
        info_decoracion.setText("Decoracion: "+caja+" "+decoracion);
        info_coste_final.setText( "Precio final: "+String.valueOf((info_res.getPrecio()+(1.5*peso)+(29*tarifa))));



    }
}
