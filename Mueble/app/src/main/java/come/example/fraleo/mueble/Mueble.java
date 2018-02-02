package come.example.fraleo.mueble;

import java.io.Serializable;


public class Mueble  implements Serializable {
    String nombre;
    String descripcion;
    int precio;
    int imagen;

    public Mueble(){}

    public Mueble(String descripcion, String nombre, int precio, int imagen){
        setDescripcion(descripcion);
        setNombre(nombre);
        setPrecio(precio);
        setImagen(imagen);
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

    public void setImagen(int imagen) { this.imagen=imagen; }


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

    public int getImagen(){
        return imagen;
    }


}


