package dal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import model.Funcionario;

public class AtendenteDao implements Serializable {
    
 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
 private static EntityManager em = emf.createEntityManager();

public static void postFuncionario(Funcionario c){
    try {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
}

    public static List<Funcionario> buscarFuncionarioPorNome(String nome) {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM Funcionario c WHERE c.nome LIKE :nome");
            sql.setParameter("nome", "%" + nome + "%");
            List<Funcionario> pessoas = sql.getResultList();
            em.getTransaction().commit();    
            return pessoas;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }
        public static void alterarFuncionario(Funcionario funcionario) {
        try{
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();     
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public static Funcionario buscarFuncionario(int id) {
        try {
            em.getTransaction().begin();
            Funcionario funcionario = em.find(Funcionario.class, id);
            em.getTransaction().commit();
            return funcionario; 
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    public static void deletaFuncionario(Funcionario funcionario) {
        try {
            em.getTransaction().begin();
            funcionario = em.merge(funcionario);
            em.remove(funcionario);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }      
    }
}