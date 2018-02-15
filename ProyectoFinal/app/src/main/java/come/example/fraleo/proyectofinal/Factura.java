package come.example.fraleo.proyectofinal;

import java.io.Serializable;

public class Factura implements Serializable {
    int id;
    int com_id;
    int game_id;
    String game_name;
    int game_price;
    String com_name;
    String com_email;

    public void setId(int id) {
        this.id = id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public void setGame_price(int game_price) {
        this.game_price = game_price;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public void setCom_email(String com_email) {
        this.com_email = com_email;
    }

    public Factura(){}

    public int getId() {
        return id;
    }

    public int getCom_id() {
        return com_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public int getGame_price() {
        return game_price;
    }

    public String getCom_name() {
        return com_name;
    }

    public String getCom_email() {
        return com_email;
    }

    public Factura(int com_id, int game_id, String game_name, int game_price, String com_name, String com_email){
        setCom_id(com_id);
        setGame_id(game_id);
        setGame_name(game_name);
        setGame_price(game_price);
        setCom_name(com_name);
        setCom_email(com_email);
    }

}
