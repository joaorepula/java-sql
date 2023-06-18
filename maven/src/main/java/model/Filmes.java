package model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Filmes")
public class Filmes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String genero;
    private int estoque;

    @OneToMany(mappedBy = "filme")
    private List<Pedido> pedidos;

    public Filmes(String nome, String genero, int estoque) {
        this.nome = nome;
        this.genero = genero;
        this.estoque = estoque;
    }
    
    public Filmes() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


    @Override
    public String toString() {
        return "Filmes [id=" + id + ", nome=" + nome + ", genero=" + genero + ", estoque=" + estoque + "]";
    }
}
