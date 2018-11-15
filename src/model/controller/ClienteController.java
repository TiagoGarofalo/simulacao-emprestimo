package model.controller;

import java.util.List;

import model.bo.ClienteBO;
import model.vo.ClienteVO;
import model.vo.Simulacao;

public class ClienteController {
	
	public static final String TIPO_RELATORIO_XLS = "xls";
	
	ClienteBO bo = new ClienteBO();

public ClienteVO inserirSimulacao(ClienteVO cliente) {
		
		return bo.salvarCliente(cliente);
		
	}

public void gerarRelatorio(List<Simulacao> simulacoesConsultadas, String caminhoEscolhido, String tipoRelatorioXls) {
	
	//TODO fazer mais validações? Quais?
			if(tipoRelatorioXls.equals(TIPO_RELATORIO_XLS)){
				bo.gerarPlanilha(simulacoesConsultadas, caminhoEscolhido);
			}else{
				bo.gerarPDF(simulacoesConsultadas, caminhoEscolhido);
			}
	
}
	
	
}
