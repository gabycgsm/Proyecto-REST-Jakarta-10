package beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ClienteBean implements Serializable {

    private List<Cliente> clientes = new ArrayList<>();
    private Cliente cliente = new Cliente();
    private int nextId = 1;

    public ClienteBean() {
        clientes.add(new Cliente(nextId++, "Juan Pérez", "0999999999"));
        clientes.add(new Cliente(nextId++, "María López", "0988888888"));
    }

    public String agregarCliente() {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) return null;
        if (cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) return null;
        cliente.setId(nextId++);
        clientes.add(cliente);
        cliente = new Cliente();
        return "listaClientes?faces-redirect=true";
    }

    public String eliminarCliente(int id) {
        clientes.removeIf(c -> c.getId() == id);
        return null;
    }

    public List<Cliente> getClientes() { return clientes; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
