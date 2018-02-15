package come.example.fraleo.proyectofinal;


import java.io.Serializable;

public class Juego  implements Serializable {
    int id;
    String nombre;
    String descripcion;
    int precio;
    int imagen;

    public Juego(){}

    public Juego(String descripcion, String nombre, int precio, int imagen){
        setDescripcion(descripcion);
        setNombre(nombre);
        setPrecio(precio);
        setImagen(imagen);
    }


    public void setId(int id) { this.id=id; }

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

    public int getId(){
        return id;
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