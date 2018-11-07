package model.controller;

import java.util.List;

import model.bo.SimulacaoBO;

import model.vo.Simulacao;

public class SimulacaoController {

	SimulacaoBO bo = new SimulacaoBO();

	public boolean validarCPF(String cpf) {
		return bo.validaCPF(cpf);
	}

	public double calculaJuros(Simulacao simula) {
		return bo.calcularJuros(simula);
	}
	
	public double calculaValorParc(Simulacao simula) {
		return bo.calcularValorParcelas(simula);
	}

	public List<Simulacao> listarContratos(Long numContrato, String cpfCliente) {
		
		return bo.listarSimulacoes(numContrato, cpfCliente);
	}

	public Simulacao inserirSimulacao(Simulacao simul) {
		
		return bo.salvarSimulacao(simul);
		
	}
	
}
