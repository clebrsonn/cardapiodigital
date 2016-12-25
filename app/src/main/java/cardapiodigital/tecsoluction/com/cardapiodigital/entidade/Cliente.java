package cardapiodigital.tecsoluction.com.cardapiodigital.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Cliente implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private long id;


    private String nome;


    private String email;


    private String telefone;


    private Date dataNascimento;
    

    private List<PedidoVenda> listaPedidoVenda;
   

//    private List <DevolucaoVenda> listaDevolucaoVenda;


    public Cliente() {
        // TODO Auto-generated constructor stub
    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return nome;
    }


}