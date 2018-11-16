package model.controller;

import java.util.List;

import model.bo.ClienteBO;
import model.vo.ClienteVO;



public class ClienteController {
	
	
	
	public boolean salvar (ClienteVO cliente) {
		ClienteBO bo = new ClienteBO();
		
		return bo.salvar(cliente); 
		
	}

	public void deletar(String cpf) {
	
		ClienteBO bo = new ClienteBO();
		bo.excluir(cpf);
	
	}

	public boolean ValidaCPF(String cpf) {
		ClienteBO bo = new ClienteBO();
				return bo.isCPF(cpf);
	}
	public List<ClienteVO> ListarTodosClientes (){
		ClienteBO bo = new ClienteBO();
		return bo.ListarTodos();
				}
}
