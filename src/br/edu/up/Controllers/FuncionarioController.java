package br.edu.up.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.Models.Cliente;
import br.edu.up.Models.Funcionario;
import br.edu.up.Models.Enums.TipoCargo;
import br.edu.up.Models.Enums.TipoCliente;

import br.edu.up.DAO.ClienteDAO;
import br.edu.up.DAO.FuncionarioDAO;

public class FuncionarioController {

  private FuncionarioDAO daos = new FuncionarioDAO();
  private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

  public FuncionarioController() {
    this.funcionarios = daos.listarFuncionario();
  }

  // Criar
  public void incluirFuncionario(Funcionario funcionario) {
    daos.gravarFuncionario(funcionario);
  }

  // Listar filmes
  public List<Funcionario> listarFuncionarios() {
    return daos.listarFuncionario();
  }

  // Atualizar
  public String atualizarFuncionario(Funcionario func) {
    try {
      Funcionario funcionario = new Funcionario(func.getDocumento(), func.getNome(), func.getIdade(),
          func.getEndereco(), func.getCargo(), func.getCodigo());
      funcionarios.add(funcionario);
      daos.atualizarFuncionario(funcionario);
      return "Funcionario Atualizado com sucesso!";

    } catch (IllegalArgumentException e) {
      return "Gênero inválido: " + e;
    }
  }

  // Deletar
  public String deletarFuncionario(int id) {
    boolean deletado = daos.deletarFuncionario(id);
    if (deletado) {
      return "Funcionario deletado com sucesso";
    } else {
      return "Código não encontrado: " + id;
    }
  }

  public void salvarDados() {
    daos.adicionarFuncionarios(funcionarios);
  }
}
