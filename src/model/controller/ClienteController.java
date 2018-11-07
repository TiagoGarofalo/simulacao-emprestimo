package model.controller;

import model.bo.ClienteBO;
import model.vo.ClienteVO;
import model.vo.Simulacao;

public class ClienteController {

public ClienteVO inserirSimulacao(ClienteVO cliente) {
		
		return ClienteBO.salvarCliente(cliente);
		
	}
	
	
}
