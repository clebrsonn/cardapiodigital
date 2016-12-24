package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;

/**
 * Created by winds on 01/12/2016.
 */
public class Categoria implements Serializable {



    private long id;

    private String nome;

    private Categoria catpai;


   // private List<Produto> produtos;


    //CONSTRUTOR PADRAO

    public Categoria() {
        // TODO Auto-generated constructor stub
    }

//    public Categoria(Categoria cat) {
//        // TODO Auto-generated constructor stub
//    	this.catpai=cat;
//    }


    //GETTERS AND SETTERS

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public long getId() {
        return id;
    }



    @Override
    public String toString() {
        return nome;
    }


    public Categoria getCatpai() {
        return catpai;
    }


    public void setCatpai(Categoria catpai) {
        this.catpai = catpai;
    }

//    public List<Produto> getProdutos() {
//        return produtos;
//    }
//
//    public void setProdutos(List<Produto> produtos) {
//        this.produtos = produtos;
//    }
}
