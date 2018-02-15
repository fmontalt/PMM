package come.example.fraleo.proyectofinal;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginSuccessActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<Juego> lista;
    Juego item = null;
    Bundle bundle;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);



        TextView txtname = (TextView) findViewById(R.id.txt_success_name);
        //TextView txtemail = (TextView) findViewById(R.id.txt_success_email);
        Button btnpedido = (Button) findViewById(R.id.btn_pedido);
        spinner = (Spinner) findViewById(R.id.spinner);
        final RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        final CheckBox caratula = (CheckBox) findViewById(R.id.caratula);
        final CheckBox banda = (CheckBox) findViewById(R.id.banda);
        final EditText unidades_edit = (EditText) findViewById(R.id.unidades);

        cargaSpinner();
        final Spinner spinner_cargado = (Spinner)findViewById(R.id.spinner);

         intent = getIntent();

        final String loginName = intent.getStringExtra("fullname");
        final String loginEmail = intent.getStringExtra("email");
        final int loginId = intent.getIntExtra("id",1);

        txtname.setText("Bienvenido, " +loginName);

        btnpedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();

                bundle.putString("email",loginEmail);
                bundle.putString("fullname",loginName);
                bundle.putInt("id",loginId);

                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.estandar:
                        bundle.putString("edicion", "Edición estandar");
                        bundle.putInt("extra_edicion",0);
                        break;
                    case R.id.especial:
                        bundle.putString("edicion", "Edición especial");
                        bundle.putInt("extra_edicion",5);
                        break;
                }
                bundle.putSerializable("infoObject",(Juego)lista.toArray()[spinner_cargado.getSelectedItemPosition()]);

                if(caratula.isChecked()){
                    bundle.putString("caratula","Con caratula especial");
                    bundle.putInt("extra_caratula",2);
                }else {
                    bundle.putString("caratula","Sin caratula especial");
                    bundle.putInt("extra_caratula",0);
                }

                if(banda.isChecked()){
                    bundle.putString("banda","Con banda sonora");
                    bundle.putInt("extra_banda",10);
                }else {
                    bundle.putString("banda","Sin banda sonora");
                    bundle.putInt("extra_banda",0);
                }

                if(unidades_edit.getText().toString().equals("")){
                    unidades_edit.setText("1");
                }

                bundle.putInt("unidades",Integer.parseInt(unidades_edit.getText().toString()));

                Intent mIntent = new Intent(LoginSuccessActivity.this, Recibo_juego.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);

            }
        });


    }

    private void cargaSpinner() {

        lista = new ArrayList<>();

        SQLiteDatabase db = new SQLiteDBHelper(this).getWritableDatabase();

        String query= "select * from juego";


        Cursor c = db.rawQuery(query, null);

            while (c.moveToNext()) {

                int id = c.getInt(c.getColumnIndex(SQLiteDBHelper.COLUMN_ID_2 ));
                String name = c.getString(c.getColumnIndex(SQLiteDBHelper.COLUMN_NAME));
                String desc = c.getString(c.getColumnIndex(SQLiteDBHelper.COLUMN_DES));
                int prec = c.getInt(c.getColumnIndex(SQLiteDBHelper.COLUMN_PRE));
                int img = c.getInt(c.getColumnIndex(SQLiteDBHelper.COLUMN_IMG));

                item = new Juego();
                item.id = id;
                item.nombre = name;
                item.descripcion = desc;
                item.precio = prec;
                item.imagen = img;
                lista.add(item);
            }

        AdaptadorJuego adaptador = new AdaptadorJuego(this, lista);

        spinner.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(LoginSuccessActivity.this);
            builder.setTitle("Información");
            builder.setMessage("¿Quieres salir al menu?");

            builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();

                }
            });

            builder.setNegativeButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(LoginSuccessActivity.this,MainActivity.class);
                    startActivity(intent);

                    finish();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();


        }

        if (id == R.id.menu_direc) {

            Intent intent = new Intent(LoginSuccessActivity.this,Actividad_fragmento.class);
            startActivity(intent);


        }

        if(id == R.id.menu_facturas){

            bundle = new Bundle();
            final int loginId = intent.getIntExtra("id",1);

            bundle.putInt("id",loginId);

            Intent intent = new Intent(LoginSuccessActivity.this,factura_personal.class);
            intent.putExtras(bundle);
            startActivity(intent);

        }

        if(id == R.id.menu_acercade){
            Intent intent = new Intent(LoginSuccessActivity.this,acercade.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }


}
