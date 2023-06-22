package controller;
import model.Funcionario;

import java.util.List;

import dal.AtendenteDao;

public class AtendenteController {

    public static Funcionario buscarClientePorId(int id) {
        try {
            return AtendenteDao.buscarFuncionario(id);      
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        }
    }
    public static void salvar(Funcionario c){
        try {
            AtendenteDao.postFuncionario(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void alterarFuncionario(Funcionario funcionario) {
        try {
            if(AtendenteDao.buscarFuncionario(funcionario.getId()) != null){
                AtendenteDao.alterarFuncionario(funcionario);
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar o cadastro");
        }
    }
    public static void deletarCliente(int id) {
        try {
            if(AtendenteDao.buscarFuncionario(id) != null){
                AtendenteDao.deletaFuncionario(AtendenteDao.buscarFuncionario(id));
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar o cadastro");
        }
    }
}
