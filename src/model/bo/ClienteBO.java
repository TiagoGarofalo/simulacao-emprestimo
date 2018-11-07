package model.bo;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {

public  ClienteVO salvarCliente(ClienteVO cliente) {
		
		return ClienteDAO.inserirCliente(cliente);
	}
	
	
}
