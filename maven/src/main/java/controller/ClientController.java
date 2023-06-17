package controller;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

import dal.ClienteDao;

public class ClientController {
    public static void salvar(Cliente c){
        try {
            ClienteDao cliente = new ClienteDao();
            cliente.postClient(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static List<Cliente> salvar(){
        try {
            ClienteDao cliente = new ClienteDao();
            List<Cliente> clientes = new ArrayList<Cliente>();
            clientes = cliente.listar();
            return clientes;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static Cliente getClientePorId(int id){
        try {
            ClienteDao cliente = new ClienteDao();
            Cliente clienteId = new Cliente();
            clienteId = cliente.listarClientPorId(id);
            return clienteId;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static Cliente deleteCliente(int id){
        try {
            ClienteDao cliente = new ClienteDao();
            Cliente clienteId = new Cliente();
            return clienteId;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
