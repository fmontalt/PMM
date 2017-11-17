package come.example.fraleo.examen_ev1;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPizzas extends ArrayAdapter {

    Activity context;
    ArrayList <Pizzas> lista;

    AdaptadorPizzas(Activity context, ArrayList <Pizzas> lista) {

        super(context, R.layout.listitem_pizzas, lista);
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
        View item = inflater.inflate(R.layout.listitem_pizzas, null);


        TextView nombre = (TextView)item.findViewById(R.id.nombre);
        nombre.setText(lista.get(position).getNombre());

        TextView zona = (TextView)item.findViewById(R.id.descripcion);
        zona.setText(lista.get(position).getDescripcion());


        TextView precio = (TextView) item.findViewById(R.id.precio);
        precio.setText(String.valueOf(lista.get(position).getPrecio()));

        //ImageView imagen = (ImageView) item.findViewById(R.id.imageView);
        //imagen.setImageDrawable(lista.get(position).getImagen());
        return(item);
    }
}





