package come.example.fraleo.proyectofinal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To hide AppBar for fullscreen.
        ActionBar ab = getSupportActionBar();
        ab.hide();

        //Referencing UserEmail, Password EditText and TextView for SignUp Now
        final EditText _txtemail = (EditText) findViewById(R.id.txtemail);
        final EditText _txtpass = (EditText) findViewById(R.id.txtpass);
        Button _btnlogin = (Button) findViewById(R.id.btnsignin);
        TextView _btnreg = (TextView) findViewById(R.id.btnreg);

        //Opening SQLite Pipeline
        dbhelper = new SQLiteDBHelper(this);
        db = dbhelper.getReadableDatabase();

        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = _txtemail.getText().toString();
                String pass = _txtpass.getText().toString();

                cursor = db.rawQuery("SELECT *FROM "+SQLiteDBHelper.TABLE_NAME+
                         " WHERE "+SQLiteDBHelper.COLUMN_EMAIL+"=? AND "+
                         SQLiteDBHelper.COLUMN_PASSWORD+"=?",new String[] {email,pass});

                if (cursor != null) {
                    if(cursor.getCount() > 0) {

                        cursor.moveToFirst();
                        //Retrieving User FullName and Email after successfull login and passing to LoginSucessActivity
                        String _fname = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_FULLNAME));
                        String _email= cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_EMAIL));

                        Toast.makeText(MainActivity.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,LoginSuccessActivity.class);
                        intent.putExtra("fullname",_fname);
                        intent.putExtra("email",_email);
                        startActivity(intent);

                        finish();
                    }
                    else {
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                       "Usuario o contraseña incorrectos",
                                       Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                }

            }
        });

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,RegisterAccountActivity.class);
                startActivity(intent);
            }
        });

    }

}
