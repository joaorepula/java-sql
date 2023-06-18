package controller;
import model.Filmes;

import java.util.List;

import dal.FilmesDao;

public class FilmesController {
    public static List<Filmes> listarFilme(){
        try {
            return FilmesDao.listar();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static List<Filmes> buscarFilmePorNome(String nome) {
        try {
            return FilmesDao.buscarFilmePorNome(nome);   
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        } 
    }
    public static Filmes buscarFilmePorId(int id) {
        try {
            return FilmesDao.buscarFilme(id);      
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        }
    }
    public static void salvar(Filmes c){
        try {
            FilmesDao.postFilme(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void alterarFilme(Filmes filme) {
        try {
            if(FilmesDao.buscarFilme(filme.getId()) != null){
                FilmesDao.alterarFilme(filme);
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar o cadastro");
        }
    }
    public static void deletarFilme(int id) {
        try {
            if(FilmesDao.buscarFilme(id) != null){
                FilmesDao.deletaFilme(FilmesDao.buscarFilme(id));
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar o cadastro");
        }
    }
}
