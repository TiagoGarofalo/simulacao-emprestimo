package model.controller;

import model.bo.VendedorBO;
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
}
