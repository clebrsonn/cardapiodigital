package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;

/**
 * Created by winds on 01/12/2016.
 */
public class Mesa implements Serializable {



    private long id;

    private String numero;

    private String status;

//    @OneToMany(mappedBy = "mesa")
//    private List<PedidoVenda> pedidos;

    public Mesa() {
        // TODO Auto-generated constructor stub
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

//    public List<PedidoVenda> getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(List<PedidoVenda> pedidos) {
//        this.pedidos = pedidos;
//    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return numero;
    }


}
