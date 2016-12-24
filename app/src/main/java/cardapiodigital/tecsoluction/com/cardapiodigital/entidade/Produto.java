package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;

/**
 * Created by winds on 01/12/2016.
 */
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;


    private long id;

    private String codebar;

    private String descricao;


    private String un_medida;

    private double precoCusto;

    private double precoVenda;


  //  private Fornecedor fornecedor;

    // @OneToMany(mappedBy = "produto")
    // private List<Item> items;


    private Categoria categoria;

    public Produto() {
        // TODO Auto-generated constructor stub
        // items = new ArrayList<Item>();
    }

//    public Fornecedor getFornecedor() {
//        return fornecedor;
//    }
//
//    public void setFornecedor(Fornecedor fornecedor) {
//        this.fornecedor = fornecedor;
//    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNumero() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUn_medida(String un_medida) {
        this.un_medida = un_medida;
    }

    public String getUn_medida() {
        return un_medida;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double preco) {
        this.precoCusto = preco;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getCodebar() {
        return codebar;
    }

    // public List<Item> getItems() {
    // return items;
    // }
    //
    //
    // public void setItems(List<Item> items) {
    // this.items = items;
    // }

    @Override
    public String toString() {
        return descricao;
    }
}
