package dal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import model.Filmes;

public class FilmesDao implements Serializable {
    
 private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
 private static EntityManager em = emf.createEntityManager();

public static void postFilme(Filmes c){
    try {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
}

public static List<Filmes> listar(){
    try {
        em.getTransaction().begin();
        Query sql = em.createQuery("SELECT c FROM Filmes c");
        List<Filmes> filmes = sql.getResultList();
        em.getTransaction().commit();
        return filmes;
    } catch (Exception e) {
        em.getTransaction().rollback();
    }
    return null;
}
    public static List<Filmes> buscarFilmePorNome(String nome) {
        try {
            em.getTransaction().begin();
            Query sql = em.createQuery("SELECT c FROM Filme c WHERE c.nome LIKE :nome");
            sql.setParameter("nome", "%" + nome + "%");
            List<Filmes> filmes = sql.getResultList();
            em.getTransaction().commit();    
            return filmes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }
        public static void alterarFilme(Filmes filmes) {
        try{
            em.getTransaction().begin();
            em.merge(filmes);
            em.getTransaction().commit();     
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public static Filmes buscarFilme(int id) {
        try {
            em.getTransaction().begin();
            Filmes filme = em.find(Filmes.class, id);
            em.getTransaction().commit();
            return filme; 
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    public static void deletaFilme(Filmes filme) {
        try {
            em.getTransaction().begin();
            //Pega o objeto pessoa e gera uma instância do banco de dados do objeto
            filme = em.merge(filme);
            //Remove o objeto instanciado
            em.remove(filme);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        }      
    }
}