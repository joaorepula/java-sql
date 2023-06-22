package dal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import model.Cliente;

public class ClienteDao implements Serializable {
    
 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
 private static EntityManager em = emf.createEntityManager();

public static void postClient(Cliente c){
    try {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
}

public static List<Cliente> listar(){
    try {
        em.getTransaction().begin();
        Query sql = em.createQuery("SELECT c FROM cliente c");
        List<Cliente> clientes = sql.getResultList();
        em.getTransaction().commit();
        return clientes;
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
    return null;
}
public static Cliente listarClienteId(int id){
    try {
        em.getTransaction().begin();
        Query sql = em.createQuery("SELECT c FROM Cliente c");
        List<Cliente> clientes = sql.getResultList();
        em.getTransaction().commit();

        for (Cliente cliente : clientes) {
            if(cliente.getId() == id){
                return cliente;
            }
        }
    System.out.println(clientes);
    return null;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        em.getTransaction().rollback();
        return null;
    }
}
    public static List<Cliente> buscarPessoaPorNome(String nome) {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM Cliente c WHERE c.nome LIKE :nome");
            sql.setParameter("nome", "%" + nome + "%");
            List<Cliente> pessoas = sql.getResultList();
            em.getTransaction().commit();    
            return pessoas;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }
        public static void alterarCliente(Cliente cliente) {
        try{
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();     
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public static Cliente buscarCliente(int id) {
        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().commit();
            return cliente; 
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    public static void deletaCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            //Pega o objeto pessoa e gera uma instância do banco de dados do objeto
            cliente = em.merge(cliente);
            //Remove o objeto instanciado
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }      
    }
}