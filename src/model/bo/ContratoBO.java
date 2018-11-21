package model.bo;

import model.dao.ContratoDAO;
import model.vo.ContratoVO;

public class ContratoBO {

	ContratoDAO dao = new ContratoDAO();
	
	public boolean salvarContrato(ContratoVO contrato) {
	
		return dao.salvarContrato(contrato);
	}
	
	

}
