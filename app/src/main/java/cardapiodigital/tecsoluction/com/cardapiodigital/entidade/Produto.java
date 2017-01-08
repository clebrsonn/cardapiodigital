package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by winds on 01/12/2016.
 */
public class Produto implements Parcelable {

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
        // items = new ArrayList<Item>();
    }

    private Produto(Parcel from){
        id = from.readLong();
        codebar = from.readString();
        descricao = from.readString();
        un_medida = from.readString();
        precoCusto = from.readDouble();
        precoVenda = from.readDouble();
        categoria = (Categoria) from.readValue(Categoria.class.getClassLoader());


//        listCatPai = new ArrayList<Categoria>();
//        from.readList(this.listCatPai,Categoria.class.getClassLoader());
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

    public void setId(long id) {
        this.id = id;
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
    public static final Parcelable.Creator<Produto>
            CREATOR = new Parcelable.Creator<Produto>(){
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(codebar);
        dest.writeString(descricao);
        dest.writeString(un_medida);
        dest.writeDouble(precoCusto);
        dest.writeDouble(precoVenda);
        dest.writeValue(categoria);


//        dest.writeList(listCatPai);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (id != produto.id) return false;
        return !(descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null);

    }

    @Override
    public int hashCode() {

//        long resultado = Parse
        Long id = getId();
        Integer result = Integer.valueOf(id.intValue());
        result = 31 * result + (id != null ? id.hashCode() : 0);


        return result;
    }
    @Override
    public String toString() {
        return descricao;
    }

    public void setNumero(String numero) {
    }
}
