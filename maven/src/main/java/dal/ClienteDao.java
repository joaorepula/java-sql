package dal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import model.Cliente;

public class ClienteDao implements Serializable {
    
    Cliente cliente = new Cliente("Joao","Email");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    EntityManager em = emf.createEntityManager();


public void postClient(Cliente c){
    try {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
}

public List<Cliente> listar(){
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
public Cliente listarClientPorId(int id){
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
}