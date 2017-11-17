package come.example.fraleo.examen_ev1;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by fraleo on 17/11/17.
 */

public class Pizzas  implements Serializable {
    String nombre;
    String descripcion;
    int precio;
   // int imagen;

    public Pizzas(){}

    public Pizzas(String descripcion, String nombre, int precio){
        setDescripcion(descripcion);
        setNombre(nombre);
        setPrecio(precio);
    }



    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public void setPrecio(int precio){
        this.precio=precio;
    }

   // public void setImagen(int imagen){
        //this.imagen=imagen;
    //}


    public String toString(){
        String cadena = descripcion;
        return cadena;
    }


    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getPrecio(){
        return precio;
    }

    //public int getImagen(){
       // return imagen;
    //}


}


