package come.example.fraleo.proyectofinal;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class Recibo_juego extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo_juego);

        openHelper = new SQLiteDBHelper(this);

        //IDS DEL XML
        final TextView text_juego = (TextView) findViewById(R.id.info_juego);
        final TextView info_precio = (TextView) findViewById(R.id.info_precio);
        final TextView info_unidades = (TextView) findViewById(R.id.info_unidades);
        final TextView info_edicion = (TextView) findViewById(R.id.info_edicion);
        final TextView info_banda = (TextView) findViewById(R.id.info_banda);
        final TextView info_caratula = (TextView) findViewById(R.id.info_caratula);
        final TextView info_coste_final = (TextView) findViewById(R.id.info_coste_final);
        final ImageView imagen = (ImageView) findViewById(R.id.imagen);
        final Button boton= (Button) findViewById(R.id.boton);

        Intent intent = getIntent();

        Juego info_juego = (Juego) intent.getSerializableExtra("infoObject");

        final int id_juego= info_juego.getId();

        String edicion = intent.getStringExtra("edicion");
        int extra_edicion = intent.getIntExtra("extra_edicion",0);

        int unidades = intent.getIntExtra("unidades",0);

        String caratula = intent.getStringExtra("caratula");
        int extra_caratula = intent.getIntExtra("extra_caratula",0);

        String banda = intent.getStringExtra("banda");
        int extra_banda = intent.getIntExtra("extra_banda",0);

        final String nom_com = intent.getStringExtra("fullname");
        final String ema_com = intent.getStringExtra("email");
        final int id_com = intent.getIntExtra("id",1);
        final String nombre_juego = info_juego.getNombre()+" "+info_juego.getDescripcion();



        text_juego.setText("Nombre videojuego: "+info_juego.getNombre()+" "+info_juego.getDescripcion());
        info_precio.setText("Precio Base: "+info_juego.getPrecio()+"€");
        int suma_extra = (int) (extra_caratula+extra_banda+extra_edicion);
        int precio_aux = info_juego.getPrecio();
        info_unidades.setText("Unidades: "+unidades);
        info_edicion.setText("Edición: "+edicion+" + "+extra_edicion+"€");
        info_caratula.setText("Caratula esp: "+caratula+" + "+extra_caratula+"€");
        info_banda.setText("BSO: "+banda+" + "+extra_banda+"€");

        imagen.setImageResource(info_juego.getImagen());

        final int precio_juego = ((precio_aux+suma_extra)*unidades);
        info_coste_final.setText("Coste final: "+precio_juego+" €");


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openHelper.getWritableDatabase();
                InsertData(id_com, id_juego, nombre_juego, precio_juego, nom_com, ema_com);

                final AlertDialog.Builder builder = new AlertDialog.Builder(Recibo_juego.this);
                builder.setTitle("Información");
                builder.setMessage("Se ha guardado tu factura");
                builder.setPositiveButton("Genial", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        dialogInterface.dismiss();
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public void InsertData(int id_com, int id_juego, String game_name, int game_price, String nom_com, String ema_com) {

        ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.COLUMN_COM_ID,id_com);
        values.put(SQLiteDBHelper.COLUMN_GAME_ID,id_juego);
        values.put(SQLiteDBHelper.COLUMN_GAME_NAME,game_name);
        values.put(SQLiteDBHelper.COLUMN_GAME_PRICE,game_price);
        values.put(SQLiteDBHelper.COLUMN_COM_NAME,nom_com);
        values.put(SQLiteDBHelper.COLUMN_COM_EMAIL,ema_com);
        long id = db.insert(SQLiteDBHelper.TABLE_NAME_3,null,values);

    }
}
