
import controller.ClientController;
import controller.FilmesController;
import controller.PedidosController;
import dal.PedidosDao;
import model.Cliente;
import model.Filmes;
import model.Pedido;
public class App {
    public static void main( String[] args ){
        System.out.println("Hello world");
        Cliente cliente = new Cliente("Repula","tahron");
        ClientController controller = new ClientController();
        Filmes filmes2 = new Filmes("Harry Potter", "Ficção", 50);
        FilmesController controllerFilme = new FilmesController();
        
        Pedido pedido = new Pedido(cliente, filmes2);
        PedidosController pedidosController = new PedidosController();
        ClientController.deletarCliente(14);
        FilmesController.salvar(filmes2);
        PedidosController.salvar(pedido);
    }
}
