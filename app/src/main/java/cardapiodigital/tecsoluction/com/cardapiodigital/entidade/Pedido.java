package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cardapiodigital.tecsoluction.com.cardapiodigital.util.StatusPedido;


public abstract class Pedido {

    protected long id;

    private Date data;

    private StatusPedido status;

    private double total;
    

    private List<Pagamento> pagamentos;

    private List<Item> items;




    public Pedido() {
        // TODO Auto-generated constructor stub
        items = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {

        return String.valueOf(id);
    }
}
