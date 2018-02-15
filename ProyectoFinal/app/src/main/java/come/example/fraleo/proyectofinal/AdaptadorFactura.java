package come.example.fraleo.proyectofinal;

/**
 * Created by fraleo on 12/02/18.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorFactura extends ArrayAdapter {

    Activity context;
    ArrayList <Factura> lista;

    AdaptadorFactura(Activity context, ArrayList <Factura> lista) {

        super(context, R.layout.listitem_factura, lista);
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
        View item = inflater.inflate(R.layout.listitem_factura, null);


        TextView com_id = (TextView)item.findViewById(R.id.com_id);
        com_id.setText(Integer.toString(lista.get(position).getCom_id()));

        TextView com_name = (TextView)item.findViewById(R.id.com_name);
        com_name.setText(lista.get(position).getCom_name());


        TextView precio = (TextView) item.findViewById(R.id.precio);
        precio.setText(String.valueOf(lista.get(position).getGame_price())+"€");

        TextView nombre_game = (TextView) item.findViewById(R.id.game_name);
        nombre_game.setText(lista.get(position).getGame_name());

        return(item);
    }
}

