package controller;
import model.Cliente;

import java.util.List;

import dal.ClienteDao;

public class ClientController {
    public static List<Cliente> listarClientes(){
        try {
            return ClienteDao.listar();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public static List<Cliente> buscarPessoaPorNome(String nome) {
        try {
            return ClienteDao.buscarPessoaPorNome(nome);   
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        } 
    }
    public static Cliente buscarClientePorId(int id) {
        try {
            return ClienteDao.buscarCliente(id);      
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        }
    }
    public static Cliente listarClienteId(int id){
        try {
            return ClienteDao.listarClienteId(id);      
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        }
}
    public static void salvar(Cliente c){
        try {
            ClienteDao.postClient(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void alterarCliente(Cliente cliente) {
        try {
            if(ClienteDao.buscarCliente(cliente.getId()) != null){
                ClienteDao.alterarCliente(cliente);
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar o cadastro");
        }
    }
    public static void deletarCliente(int id) {
        try {
            if(ClienteDao.buscarCliente(id) != null){
                ClienteDao.deletaCliente(ClienteDao.buscarCliente(id));
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar o cadastro");
        }
    }
}
