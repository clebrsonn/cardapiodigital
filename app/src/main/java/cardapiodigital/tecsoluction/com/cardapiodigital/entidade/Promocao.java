package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;
import java.util.Date;


public class Promocao implements Serializable {

    private long id;

    private String numero;

    private String nome;

    private Date datainicio;

    private Date datafim;



    public Promocao() {
        // TODO Auto-generated constructor stub
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    @Override
    public String toString() {
        return nome;
    }


}
