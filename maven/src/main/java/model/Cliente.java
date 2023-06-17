package model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Pessoa")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome,email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    public Cliente(){}

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
    }
}
