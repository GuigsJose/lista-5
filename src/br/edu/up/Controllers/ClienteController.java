package br.edu.up.Controllers;

import br.edu.up.Models.Cliente;
import br.edu.up.Models.Enums.TipoCliente;

public class ClienteController {

    public void RegistrarCliente(String doc, String nome, int idade, String endereco, TipoCliente tipoCliente) {
        Cliente cliente = new Cliente(doc, nome, idade, endereco, tipoCliente);
    }
}
