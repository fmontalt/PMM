package come.example.fraleo.menucreate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import static come.example.fraleo.menucreate.R.id.lblMensaje;

public class MainActivity extends AppCompatActivity {
    TextView lblMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMensaje = (TextView ) findViewById(R.id.lblMensaje);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case R.id.MnuOpc2:
                Intent miIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(miIntent);
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}
}
