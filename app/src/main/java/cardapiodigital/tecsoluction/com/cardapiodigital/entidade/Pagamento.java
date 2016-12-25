package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;


public class Pagamento implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private long id;

    private String numero;

    private String nome;

    private String tipo;

    private int parcelas;
//
    private Pedido pedido;
//    
//    private String 
    

    public Pagamento() {
        // TODO Auto-generated constructor stub
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public String toString() {
        return nome;
    }

}