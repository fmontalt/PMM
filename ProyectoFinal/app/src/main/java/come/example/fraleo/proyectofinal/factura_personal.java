package come.example.fraleo.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class factura_personal extends AppCompatActivity {
    Spinner spinner;
    Bundle bundle;
    Intent intent;
    Factura item = null;
    ArrayList<Factura> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lista = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura_personal);

        intent = getIntent();
        final int id = intent.getIntExtra("id",1);

        spinner = (Spinner) findViewById(R.id.spinner);
        cargaSpinner(id);
        final Spinner spinner_cargado = (Spinner)findViewById(R.id.spinner);
    }

    private void cargaSpinner(int id) {


        SQLiteDatabase db = new SQLiteDBHelper(this).getWritableDatabase();

        String query= "select * from factura where compradorid = "+id;


        Cursor c = db.rawQuery(query, null);

        while (c.moveToNext()) {
            int compra_id = c.getInt(c.getColumnIndex(SQLiteDBHelper.COLUMN_COM_ID));
            String compra_nom = c.getString(c.getColumnIndex(SQLiteDBHelper.COLUMN_COM_NAME));
            String game_nom = c.getString(c.getColumnIndex(SQLiteDBHelper.COLUMN_GAME_NAME));
            int game_prec = c.getInt(c.getColumnIndex(SQLiteDBHelper.COLUMN_GAME_PRICE));

            item = new Factura();
            item.com_id = compra_id;
            item.com_name = compra_nom;
            item.game_price = game_prec;
            item.game_name = game_nom ;
            lista.add(item);

        }
        AdaptadorFactura adaptador = new AdaptadorFactura(this, lista);

        spinner.setAdapter(adaptador);
    }
}
