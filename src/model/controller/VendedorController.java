package model.controller;

import java.util.List;

import model.bo.VendedorBO;
import model.dao.VendedorDAO;
import model.vo.VendedorVO;

public class VendedorController {
	VendedorBO bo = new VendedorBO();

	public boolean salvar(VendedorVO vendedor) {

		return bo.salvar(vendedor);

	}

	public boolean deletar(String cpf) {

		return bo.excluir(cpf);

	}

	public boolean ValidaCPF(String cpf) {

		return bo.isCPF(cpf);
	}

	public static List<VendedorVO> ListarTodosClientes() {
		VendedorBO bo = new VendedorBO();
		return bo.Listartodos();
	}

	public boolean verificarexist(VendedorVO novoVendedor) {
		VendedorDAO dao = new VendedorDAO();
		return (boolean) dao.verificarexist(novoVendedor);
	}
}
