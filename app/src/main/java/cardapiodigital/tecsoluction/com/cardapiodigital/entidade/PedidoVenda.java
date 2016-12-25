package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import cardapiodigital.tecsoluction.com.cardapiodigital.util.OrigemPedido;
import cardapiodigital.tecsoluction.com.cardapiodigital.util.TipoPedido;

/**
 * Created by winds on 01/12/2016.
 */
public class PedidoVenda extends Pedido {

    //CLIENTE DO PEDIDO DE VENDA
    private Cliente cliente;


    // VENDA OOU COMPRA
    private TipoPedido tipo;


    // SE ORIGEM FOR MESA

    private OrigemPedido origempedido;

    //preencher mesa
    private Mesa mesa;


    //LISTA DE ITENS DO PEDIDO DE VENDA
//    @OneToMany
//    private List<Item> listaItensVenda;





    //lista de devolucoes de compra
//    @JsonIgnore
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy="pedidoVenda")
//    private List<DevolucaoVenda> listaDevolucao;





    //CONSTRUTOR PADRÃƒO
    public PedidoVenda() {

//        listaDevolucao = new ArrayList<>();
        tipo.VENDA.values();
    }



    public TipoPedido getTipo() {
//    	TipoPedido tipovenda = tipo.VENDA;
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }



    public OrigemPedido getOrigemPedido() {

        return origempedido;
    }



    public void setOrigemPedido(OrigemPedido origem) {
        this.origempedido = origem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


//
//	public List<Item> getListaItensVenda() {
//		return listaItensVenda;
//	}
//
//
//
//	public void setListaItensVenda(List<Item> listaItensVenda) {
//		this.listaItensVenda = listaItensVenda;
//	}


//
//    public List<DevolucaoVenda> getListaDevolucao() {
//        return listaDevolucao;
//    }
//
//
//
//    public void setListaDevolucao(List<DevolucaoVenda> listaDevolucao) {
//        this.listaDevolucao = listaDevolucao;
//    }

    public Mesa getMesa() {
        return mesa;
    }

    public OrigemPedido getOrigempedido() {
        return origempedido;
    }
}
