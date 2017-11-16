package come.example.fraleo.ejerrecopilatorio;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class AdaptadorZonas extends ArrayAdapter {

    Activity context;
    ArrayList <ZonasEnvio> lista;

    AdaptadorZonas(Activity context, ArrayList <ZonasEnvio> lista) {

        super(context, R.layout.listitem_zonas, lista);
        this.lista = lista;
        this.context = context;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = getView(position,convertView,parent);
        return view;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.listitem_zonas, null);
        TextView zona = (TextView)item.findViewById(R.id.zona);
        zona.setText(lista.get(position).getZona());
        TextView nombre = (TextView)item.findViewById(R.id.nombre);
        nombre.setText(lista.get(position).getNombre());
        TextView precio = (TextView) item.findViewById(R.id.precio);
        precio.setText(String.valueOf(lista.get(position).getPrecio()));
        return(item);
    }
}
