package dal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import model.Pedido;


public class PedidosDao implements Serializable {
    
 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
 private static EntityManager em = emf.createEntityManager();

public static void postPedido(Pedido pedido){
    try {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
    } catch (Exception e) {
        System.out.println(e.getMessage());
        em.getTransaction().rollback();
        e.printStackTrace(); 
    }
}


public static List<Pedido> listar(){
    try {
        em.getTransaction().begin();
        Query sql = em.createQuery("SELECT p FROM pedido p");
        List<Pedido> pedido = sql.getResultList();
        em.getTransaction().commit();
        return pedido;
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
    return null;
}
    public static List<Pedido> buscarPedidoPorNome(String nome) {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM pedido c WHERE c.nome LIKE :nome");
            sql.setParameter("nome", "%" + nome + "%");
            List<Pedido> pedido = sql.getResultList();
            em.getTransaction().commit();    
            return pedido;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }
        public static void alterarPedido(Pedido pedido) {
        try{
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();     
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public static Pedido buscarPedido(int id) {
        try {
            em.getTransaction().begin();
            Pedido pedido = em.find(Pedido.class, id);
            em.getTransaction().commit();
            return pedido; 
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    public static void deletaPedido(Pedido pedido) {
        try {
            em.getTransaction().begin();
            //Pega o objeto pessoa e gera uma instância do banco de dados do objeto
            pedido = em.merge(pedido);
            //Remove o objeto instanciado
            em.remove(pedido);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }      
    }
}