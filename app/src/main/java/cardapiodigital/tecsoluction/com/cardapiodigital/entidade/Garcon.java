package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;

/**
 * Created by winds on 01/12/2016.
 */
public class Garcon implements Serializable{


    private static final long serialVersionUID = 1L;

    private long id;

    private String nome;

    private String senha;


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
        return nome;
    }

    public void setNomegarcon(String nomegarcon) {
        this.nome = nomegarcon;
    }

    public String getSenhagarcon() {
        return senha;
    }

    public void setSenhagarcon(String senhagarcon) {
        this.senha = senhagarcon;
    }


    @Override
    public String toString() {
        return nome;
    }
}
