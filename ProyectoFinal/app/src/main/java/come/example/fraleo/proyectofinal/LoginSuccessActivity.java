package come.example.fraleo.proyectofinal;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {

    private static final int SELECT_PHOTO = 100;
    ImageView dpImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        //To hide AppBar for fullscreen.


        TextView txtname = (TextView) findViewById(R.id.txt_success_name);
        TextView txtemail = (TextView) findViewById(R.id.txt_success_email);
        Button btnpedido = (Button) findViewById(R.id.btn_pedido);


        Intent intent = getIntent();

        String loginName = intent.getStringExtra("fullname");
        String loginEmail = intent.getStringExtra("email");
        txtname.setText("Bienvenido, " +loginName);
        txtemail.setText(loginEmail);


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

        return super.onOptionsItemSelected(item);
    }


}
