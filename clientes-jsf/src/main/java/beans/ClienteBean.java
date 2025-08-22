package beans;

import com.epn.clase.ejb.local.ClienteBeanLocal;
import com.epn.clase.jpa.Clientes;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ClienteBean implements Serializable {
    
    @Inject
    private ClienteBeanLocal clienteLocal;

    private List<Clientes> clientes = new ArrayList<>();
    private Clientes cliente = new Clientes();
    //private int nextId = 1;
    
    @PostConstruct
    public void Init(){
        clientes = clienteLocal.obtenerClientes();
    }

    public ClienteBean() {
        //clientes.add(new Cliente(nextId++, "Juan Pérez", "0999999999"));
        //clientes.add(new Cliente(nextId++, "María López", "0988888888"));
    }

    public String agregarCliente() {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) return null;
        if (cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) return null;
        //cliente.setId(nextId++);
        //clientes.add(cliente);
        clienteLocal.agregarCliente(cliente);
        cliente = new Clientes();
        return "listaClientes?faces-redirect=true";
    }

    public String eliminarCliente(int id) {
        clientes.removeIf(c -> c.getId() == id);
        return null;
    }

    /*public List<Cliente> getClientes() { return clientes; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }*/

    public List<Clientes> getClientes() {
        return clientes;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
}
