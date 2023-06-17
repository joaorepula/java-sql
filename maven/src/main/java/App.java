import javax.persistence.*;

import controller.ClientController;
import model.Cliente;
public class App {
    public static void main( String[] args ){
        System.out.println("Hello world");
        Cliente cliente = new Cliente("Joao","Email");
        Cliente cliente2 = new Cliente("Joao","Email");
        ClientController controller = new ClientController();

        ClientController.salvar(cliente2);
    }
}
