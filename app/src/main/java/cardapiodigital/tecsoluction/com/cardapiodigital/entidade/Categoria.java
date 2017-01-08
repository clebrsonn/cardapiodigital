package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by winds on 01/12/2016.
 */
public class Categoria implements Parcelable {



    private long id;

    private String nome;

    private Categoria catpai;

//    private List<Categoria> listCatPai;


   // private List<Produto> produtos;


    //CONSTRUTOR PADRAO

    public Categoria() {

    }

    private Categoria(Parcel from){
        id = from.readLong();
        nome = from.readString();
        catpai = (Categoria) from.readValue(Categoria.class.getClassLoader());
//        listCatPai = new ArrayList<Categoria>();
//        from.readList(this.listCatPai,Categoria.class.getClassLoader());
    }




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


    public void setId(long id) {
        this.id = id;
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

//    public List<Categoria> getListCatPai() {
//        return listCatPai;
//    }
//    public void setListCatPai(List<Categoria> categorias) {
//        this.listCatPai = categorias;
//    }

//    public String getCategoriaAsString() {
//        String aux = "";
//        for(int i = 0, tam = listCatPai.size(); i < tam; i++){
//            aux += listCatPai.get(i).getNome()+" ("+listCatPai.get(i).getId()+"); ";
//        }
//        return aux;
//    }




    public static final Parcelable.Creator<Categoria>
            CREATOR = new Parcelable.Creator<Categoria>(){
        @Override
        public Categoria createFromParcel(Parcel in) {
            return new Categoria(in);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nome);
        dest.writeValue(catpai);
//        dest.writeList(listCatPai);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        if (id != categoria.id) return false;
        return !(nome != null ? !nome.equals(categoria.nome) : categoria.nome != null);

    }

    @Override
    public int hashCode() {

//        long resultado = Parse
        Long id = getId();
        Integer result = Integer.valueOf(id.intValue());
        result = 31 * result + (nome != null ? nome.hashCode() : 0);


        return result;
    }

}
