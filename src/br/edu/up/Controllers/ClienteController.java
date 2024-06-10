package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.edu.up.Models.Cliente;

public class ClienteController {
    List<Cliente> Clientes = new ArrayList<Cliente>();

    public void RegistrarCliente(Cliente cliente) {
        Clientes.add(cliente);
    }

    public List<Cliente> getCliente(int codigo) {
        return Clientes.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
    }

    public String ConsultarClientes() {
        return Clientes.toString();
    }

    public void RemoverCliente(int codigo) {
        Clientes.remove(codigo);
    }
}
