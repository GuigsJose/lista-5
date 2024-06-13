package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.Models.Cliente;
import br.edu.up.Models.Enums.TipoCliente;

import br.edu.up.DAO.ClienteDAO;

public class ClienteController {

    private ClienteDAO daos = new ClienteDAO();
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public ClienteController() {
        this.clientes = daos.listarClientes();
    }

    // Criar
    public void incluirCliente(Cliente cliente) {
        daos.gravarCliente(cliente);
    }

    // Listar filmes
    public List<Cliente> listarCliente() {
        return daos.listarClientes();
    }

    // Atualizar
    public String atualizarCliente(String documento, String nome, int idade, String endereco, TipoCliente tipoCliente,
            int codigo) {
        try {
            Cliente cliente = new Cliente(documento, nome, idade, endereco, tipoCliente, codigo);
            clientes.add(cliente);
            daos.atualizarCliente(cliente);
            return "Cliente Atualizado com sucesso!";

        } catch (IllegalArgumentException e) {
            return "Gênero inválido: " + e;
        }
    }

    // Deletar
    public String deletarCliente(int id) {
        boolean deletado = daos.deletarCliente(id);
        if (deletado) {
            return "Cliente deletado com sucesso";
        } else {
            return "Código não encontrado: " + id;
        }
    }
}
