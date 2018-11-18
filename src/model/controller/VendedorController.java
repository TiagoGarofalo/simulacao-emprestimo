package model.controller;

import model.bo.VendedorBO;
import model.vo.VendedorVO;

public class VendedorController {
	VendedorBO bo = new VendedorBO();
	
	public boolean salvar (VendedorVO vendedor) {
		
		
		return bo.salvar(vendedor); 
		
	}

	public void deletar(String cpf) {
	
		
		bo.excluir(cpf);
	
	}

	public boolean ValidaCPF(String cpf) {
		
				return bo.isCPF(cpf);
	}
}
