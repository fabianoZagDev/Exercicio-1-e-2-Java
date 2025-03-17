import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private String cliente;
    private List<Prato> listaDePratos = new ArrayList<>();
    private double total;

    public Pedido(int numeroPedido, String cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
    }

    public void adicionarPrato(Prato prato) {
        listaDePratos.add(prato);
        total += prato.getPreco();
    }

    public void removerPrato(Prato prato) {
        if (listaDePratos.remove(prato)) {
            total -= prato.getPreco();
        }
    }

    public double calcularTotal() { return total; }

    public static void main(String[] args) {
        Pedido pedido = new Pedido(1, "Maria");
        Prato pizza = new Prato("Pizza", 35.0, "Pizza de queijo");
        Prato suco = new Prato("Suco", 10.0, "Suco de laranja");

        pedido.adicionarPrato(pizza);
        pedido.adicionarPrato(suco);
        System.out.println("Total do pedido: R$" + pedido.calcularTotal());
    }
}
