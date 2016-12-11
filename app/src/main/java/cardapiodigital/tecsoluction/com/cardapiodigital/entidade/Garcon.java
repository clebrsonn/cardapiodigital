package cardapiodigital.tecsoluction.com.cardapiodigital.cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;

/**
 * Created by winds on 01/12/2016.
 */
public class Garcon implements Serializable{

    private long id;

    private String nomegarcon;

    private String senhagarcon;


    // construtor
    public Garcon() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomegarcon() {
        return nomegarcon;
    }

    public void setNomegarcon(String nomegarcon) {
        this.nomegarcon = nomegarcon;
    }

    public String getSenhagarcon() {
        return senhagarcon;
    }

    public void setSenhagarcon(String senhagarcon) {
        this.senhagarcon = senhagarcon;
    }


    @Override
    public String toString() {
        return "Garcon{" +
                "nomegarcon='" + nomegarcon + '\'' +
                '}';
    }
}
