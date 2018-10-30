package model.controller;

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
	
}
