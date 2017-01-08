package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


public class Promocao implements Parcelable {

    private long id;

    private String numero;

    private String nome;

    private Date datainicio;

    private Date datafim;


    public void setId(long id) {
        this.id = id;
    }

    public Promocao() {

    }


    private Promocao(Parcel from){
        id = from.readLong();
        nome = from.readString();
        numero = from.readString();
        datainicio = (Date) from.readValue(Promocao.class.getClassLoader());
        datafim = (Date) from.readValue(Promocao.class.getClassLoader());
//        listCatPai = new ArrayList<Categoria>();
//        from.readList(this.listCatPai,Categoria.class.getClassLoader());
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


    public static final Parcelable.Creator<Promocao>
            CREATOR = new Parcelable.Creator<Promocao>(){
        @Override
        public Promocao createFromParcel(Parcel in) {
            return new Promocao(in);
        }

        @Override
        public Promocao[] newArray(int size) {
            return new Promocao[size];
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
        dest.writeString(numero);
        dest.writeValue(datainicio);
        dest.writeValue(datafim);
//        dest.writeList(listCatPai);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promocao promocao = (Promocao) o;

        if (id != promocao.id) return false;
        return !(nome != null ? !nome.equals(promocao.nome) : promocao.nome != null);

    }

    @Override
    public int hashCode() {

//        long resultado = Parse
        Long id = getId();
        Integer result = Integer.valueOf(id.intValue());
        result = 31 * result + (nome != null ? nome.hashCode() : 0);


        return result;
    }


    @Override
    public String toString() {
        return nome;
    }


}
