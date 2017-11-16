package come.example.fraleo.ejerrecopilatorio;


import java.io.Serializable;

public class ZonasEnvio implements Serializable{
    String  zona;
    String nombre;
    int precio;

    public  ZonasEnvio(){}

    public ZonasEnvio(String zona, String nombre, int precio){
        setZona(zona);
        setNombre(nombre);
        setPrecio(precio);
    }

    public void setZona(String zona){
        this.zona=zona;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setPrecio(int precio){
        this.precio=precio;
    }

    public String toString(){
        String cadena = zona;
        return cadena;
    }

    public String getZona(){
        return zona;
    }
    public String getNombre(){
        return nombre;
    }

    public int getPrecio(){
        return precio;
    }

}
