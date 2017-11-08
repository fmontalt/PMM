package come.example.fraleo.listaelementos;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class actividad_2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_2);
        //
        Bundle bundle = getIntent().getExtras();
        Titular titu = ((Titular) bundle.getSerializable("seria"));
        final ImageView ivlImagen = (ImageView) findViewById(R.id.ivlImagen);
        final TextView tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        final TextView tvSubtitulo = (TextView) findViewById(R.id.tvSubtitulo);

        ivlImagen.setBackground(getDrawable(titu.getImagen()));
        tvTitulo.setText(titu.getTitulo());
        tvSubtitulo.setText(titu.getSubtitulo());
        //String mensaje = "Titulo:"+titu.getTitulo();
        //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();


    }
}
