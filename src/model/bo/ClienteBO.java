package model.bo;

import java.util.List;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;
import model.vo.Simulacao;

public class ClienteBO {

	public  ClienteVO salvarCliente(ClienteVO cliente) {

		return ClienteDAO.inserirCliente(cliente);
	}

	public void gerarPlanilha(List<Simulacao> simulacoesConsultadas, String caminhoEscolhido) {

		GeradorPlanilha gerador = new GeradorPlanilha();
		gerador.gerarPlanilhaProdutos(simulacoesConsultadas, caminhoEscolhido);

	}

	public void gerarPDF(List<Simulacao> simulacoesConsultadas, String caminhoEscolhido) {
		// TODO Auto-generated method stub

	}


}
