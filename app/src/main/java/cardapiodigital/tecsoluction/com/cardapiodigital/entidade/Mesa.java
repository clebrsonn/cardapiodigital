package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by winds on 01/12/2016.
 */
public class Mesa implements Parcelable {



    private long id;

    private String numero;

    private String status;

//    @OneToMany(mappedBy = "mesa")
//    private List<PedidoVenda> pedidos;

    public Mesa() {

    }

    private Mesa(Parcel from){
        id = from.readLong();
        numero = from.readString();
        status = from.readString();
//        listCatPai = new ArrayList<Categoria>();
//        from.readList(this.listCatPai,Categoria.class.getClassLoader());
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

    public static final Parcelable.Creator<Mesa>
            CREATOR = new Parcelable.Creator<Mesa>(){
        @Override
        public Mesa createFromParcel(Parcel in) {
            return new Mesa(in);
        }

        @Override
        public Mesa[] newArray(int size) {
            return new Mesa[size];
        }
    };

    @Override
    public int describeContents() {
        return this.hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(numero);
        dest.writeString(status);
//        dest.writeList(listCatPai);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mesa mesa = (Mesa) o;

        if (id != mesa.id) return false;
        return !(numero != null ? !numero.equals(mesa.numero) : mesa.numero != null);

    }

    @Override
    public int hashCode() {

//        long resultado = Parse
        Long id = getId();
        Integer result = Integer.valueOf(id.intValue());
        result = 31 * result + (numero != null ? numero.hashCode() : 0);


        return result;
    }

    @Override
    public String toString() {
        return numero;
    }


}
