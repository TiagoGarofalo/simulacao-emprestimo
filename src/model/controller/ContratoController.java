package model.controller;

import model.bo.ContratoBO;
import model.vo.ContratoVO;

public class ContratoController {

	ContratoBO bo = new ContratoBO();

	public boolean salvarContrato(ContratoVO contrato) {

		return bo.salvarContrato(contrato);

	}

}
