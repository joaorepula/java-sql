package controller;

import java.util.List;

import dal.PedidosDao;
import model.Pedido;


//!TODO implementar Código para salvar os relacionamentos-
public class PedidosController {
        public static List<Pedido> listarPedidos(){
        try {
            return PedidosDao.listar();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static List<Pedido> buscarFilmePorNome(String nome) {
        try {
            return PedidosDao.buscarPedidoPorNome(nome);   
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        } 
    }
    public static Pedido buscarPedidoPorId(int id) {
        try {
            return PedidosDao.buscarPedido(id);      
        } catch (Exception e) {
            System.out.println("Erro ao buscar o cadastro");
            return null;
        }
    }
    public static void salvar(Pedido c){
        try {
            PedidosDao.postPedido(c);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void alterarPedido(Pedido pedido) {
        try {
            if(PedidosDao.buscarPedido(pedido.getId()) != null){
                PedidosDao.alterarPedido(pedido);
            }
        } catch (Exception e) {
            System.out.println("Erro ao alterar o cadastro");
        }
    }
    public static void deletarPedido(int id) {
        try {
            if(PedidosDao.buscarPedido(id) != null){
                PedidosDao.deletaPedido(PedidosDao.buscarPedido(id));
            }
        } catch (Exception e) {
            System.out.println("Erro ao deletar o cadastro");
        }
    }
}
