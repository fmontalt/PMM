package come.example.fraleo.listaelementos;

import android.os.Bundle;

import java.io.Serializable;

public class Titular implements Serializable{

    private String titulo;
    private String subtitulo;
    private int imagen;
    public Titular(String tit, String sub, int imagen) {
        titulo = tit;
        subtitulo = sub;
        this.imagen = imagen;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
    public int getImagen(){
        return imagen;
    }
}
