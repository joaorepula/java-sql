
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


        //******************************* Cliente **************************************************************/
        Cliente cliente = new Cliente("NOvo Clientote","Clientote");
        ClientController controller = new ClientController();
        ClientController.salvar(cliente);
        // System.out.println(cliente.getId());
        // ClientController.alterarCliente(cliente);

        // System.out.println(ClientController.buscarPessoaPorNome("NOvo"));
        // System.out.println(ClientController.buscarClientePorId(cliente.getId()));
        // System.out.println(ClientController.listarClientes());
        // System.out.println(ClientController.listarClienteId(cliente.getId()));
        // ClientController.deletarCliente(cliente.getId());
        //*****************************************************************************************************************/

        //******************************* Atendente **************************************************************/
        // Atendente atende = new Atendente("Joao", 1500, 15);
        // AtendenteController.salvar(atende);
        // AtendenteController.alterarFuncionario(atende);
        // System.out.println(AtendenteController.buscarClientePorId(atende.getId()));
        // AtendenteController.deletarCliente(atende.getId());

        //*****************************************************************************************************************/

        //******************************* Filmes **************************************************************/
        Filmes filmes2 = new Filmes("Novo filme", "Ficção", 50);
        FilmesController controllerFilme = new FilmesController();
        FilmesController.salvar(filmes2);
        // System.out.println(FilmesController.buscarFilmePorId(filmes2.getId()));
        // System.out.println(FilmesController.listarFilme());
        FilmesController.alterarFilme(filmes2);
        // FilmesController.deletarFilme(filmes2.getId());

        // //*****************************************************************************************************************/

        // //******************************* Pedido **************************************************************/

        Pedido pedido = new Pedido(cliente, filmes2);
        System.out.println(filmes2.getId());
        PedidosController pedidosController = new PedidosController();
        
        PedidosController.salvar(pedido);
        PedidosController.alterarPedido(pedido);
        // System.out.println(PedidosController.buscarPedidoPorId(pedido.getId()));
        System.out.println(PedidosController.listarPedidos());
        PedidosController.deletarPedido(pedido.getId());

        //*****************************************************************************************************************/


 




    }
}

