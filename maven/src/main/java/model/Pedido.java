package model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE )
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.MERGE )
    private Filmes filme;

    public Pedido(Cliente cliente, Filmes filme) {
        this.cliente = cliente;
        this.filme = filme;
    }

    public Pedido() {}

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", cliente=" + cliente + ", filme=" + filme + "]";
    }
}
