package come.example.fraleo.basededatos;

import java.io.Serializable;

public class Cliente implements Serializable {
    int codigo;
    String nombre;
    String telefono;

    public Cliente(){}

    public Cliente(int codigo, String nombre, String telefono) {
        setCodigo(codigo);
        setNombre(nombre);
        setTelefono(telefono);
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public String toString(){
        String cadena = nombre;
        return cadena;
    }

}

