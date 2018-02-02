package come.example.fraleo.basededatos;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorCliente extends ArrayAdapter <Cliente> {
    Activity context;
    ArrayList<Cliente> lista;

    AdaptadorCliente(Activity context, ArrayList<Cliente> lista){
        super(context, R.layout.clientes_spinner, lista);
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
        View item = inflater.inflate(R.layout.clientes_spinner, null);

        TextView codigo = (TextView)item.findViewById(R.id.codigo);
        codigo.setText(String.valueOf(lista.get(position).getCodigo()));

        TextView nombre = (TextView)item.findViewById(R.id.nombre);
        nombre.setText(lista.get(position).getNombre());


        TextView precio = (TextView) item.findViewById(R.id.telefono);
        precio.setText(String.valueOf(lista.get(position).getTelefono()));

        return(item);
    }

}



