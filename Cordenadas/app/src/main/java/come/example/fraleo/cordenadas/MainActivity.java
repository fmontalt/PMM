package come.example.fraleo.cordenadas;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Http Connection";
    private EditText longitud;
    private EditText latitud;
    private Button boton;
    private TextView texto;
    private ArrayAdapter arrayAdapter = null;
    private String direccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        longitud = (EditText)findViewById(R.id.longitud);
        latitud = (EditText)findViewById(R.id.latitud);
        boton = (Button)findViewById(R.id.boton);
        texto = (TextView)findViewById(R.id.texto);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng="
                       +latitud.getText().toString()+","+longitud.getText().toString()+"&sensor=false";

                //final String url = "http://maps.googleapis.com/maps/api/geocode/json?latlng=38.1525,-0.88972&sensor=false";


                new AsyncHttpTask().execute(url);

            }
        });


    }
    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;

            HttpURLConnection urlConnection = null;

            Integer result = 0;
            try {
                /* forming th java.net.URL object */
                URL url = new URL(params[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                 /* optional request header */
                urlConnection.setRequestProperty("Content-Type", "application/json");

                /* optional request header */
                urlConnection.setRequestProperty("Accept", "application/json");

                /* for Get request */
                urlConnection.setRequestMethod("GET");

                int statusCode = urlConnection.getResponseCode();

                /* 200 represents HTTP OK */
                if (statusCode ==  200) {

                    inputStream = new BufferedInputStream(urlConnection.getInputStream());

                    String response = convertInputStreamToString(inputStream);

                    parseResult(response);

                    result = 1;

                }else{
                    result = 0;
                }

            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }

            return result;
        }


        @Override
        protected void onPostExecute(Integer result) {

            if(result == 1){
                Toast toast2 =
                        Toast.makeText(getApplicationContext(),
                                direccion, Toast.LENGTH_SHORT);

                toast2.show();

            }else{
                Log.e(TAG, "Failed to fetch data!");
            }
        }

    }
    private String convertInputStreamToString(InputStream inputStream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        String line = "";
        String result = "";

        while((line = bufferedReader.readLine()) != null){
            result += line;
        }

        if(null!=inputStream){
            inputStream.close();
        }

        return result;
    }
    private void parseResult(String result) {

        try{
            JSONObject response = new JSONObject(result);

            JSONArray resultado = response.optJSONArray("results");
            direccion = "No hay datos";


            JSONObject post = resultado.optJSONObject(0);
            direccion = post.getString("formatted_address");


        }catch (JSONException e){
        Log.e("Error","error",e);
        }
    }
}
