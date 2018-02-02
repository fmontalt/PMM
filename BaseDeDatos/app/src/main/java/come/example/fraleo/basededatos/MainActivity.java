package come.example.fraleo.basededatos;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<Cliente> lista;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);

        //Abrimos la base de datos en modo escritura
        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        //Obtenemos referencia a la base de datos para poder modificarla.
        SQLiteDatabase bd = cliBDh.getWritableDatabase();

        //En caso de abrir de forma correcta la base de datos
        if (bd!=null) {
            //Introducimos 3 clientes de ejemplo
            for (int cont=1; cont<=3; cont++) {
                //Creamos los datos
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                //Introducimos los datos en la tabla Clientes
                bd.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                        "VALUES (" + codigo + ", ' " + nombre + "', '" + telefono + "')");
            }
/*        		//Ejemplo Select1
        		String[] args3 = new String[]{"cli1"};
        		Cursor c = bd.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);

        		//Ejemplo Select2


        		*/
            String[] campos = new String[] {"nombre", "telefono"};
            String[] args4 = new String[] {"cli1"};
     	    Cursor c = bd.rawQuery("select * from clientes",null);
            lista = new ArrayList<Cliente>();

        		if (c.moveToFirst()) {
        			do {
                        int codigoCLi = c.getInt(0);
        				String nombreCli = c.getString(1);
        				String telefonoCli = c.getString(2);

                        String datosCliente = nombreCli + "..." + telefonoCli;
                        //Toast.makeText(this, datosCliente, Toast.LENGTH_SHORT).show();

                        lista.add(new Cliente(codigoCLi, nombreCli, telefonoCli));

        			} while (c.moveToNext());
        		}
                        AdaptadorCliente adaptador = new AdaptadorCliente(this, lista);
                        spinner.setAdapter(adaptador);
            bd.close();
        }


    }

}
