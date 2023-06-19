
import controller.AtendenteController;
import controller.ClientController;
import controller.FilmesController;
import controller.PedidosController;
import dal.PedidosDao;
import model.Atendente;
import model.Cliente;
import model.Filmes;
import model.Pedido;
import model.Funcionario;

public class App {
    public static void main( String[] args ){
        System.out.println("Hello world");
        Cliente cliente = new Cliente("NOvo vcliente","tahron");
        ClientController controller = new ClientController();
        Filmes filmes2 = new Filmes("Novo filme", "Ficção", 50);
        FilmesController controllerFilme = new FilmesController();

        Pedido pedido = new Pedido(cliente, filmes2);
        PedidosController pedidosController = new PedidosController();
        ClientController.deletarCliente(14);
        FilmesController.salvar(filmes2);
        PedidosController.salvar(pedido);

        // Atendente atende = new Atendente("Joao", 1500, 15);
        // AtendenteController.salvar(atende);
        System.out.println(ClientController.listarClienteId(1));
    }
}

