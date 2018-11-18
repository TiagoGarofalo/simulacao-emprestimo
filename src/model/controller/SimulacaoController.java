package model.controller;

import java.util.List;

import model.bo.SimulacaoBO;

import model.vo.SimulacaoVO;

public class SimulacaoController {

	SimulacaoBO bo = new SimulacaoBO();

	public boolean validarCPF(String cpf) {
		return bo.validaCPF(cpf);
	}

	public double calculaJuros(SimulacaoVO simula) {
		return bo.calcularJuros(simula);
	}
	
	public double calculaValorParc(SimulacaoVO simula) {
		return bo.calcularValorParcelas(simula);
	}

	public List<SimulacaoVO> listarContratos(Long numContrato, String cpfCliente) {
		
		return bo.listarSimulacoes(numContrato, cpfCliente);
	}

	public SimulacaoVO inserirSimulacao(SimulacaoVO simul) {
		
		return bo.salvarSimulacao(simul);
		
	}

	public void salvar(SimulacaoVO simula) {
		// TODO Auto-generated method stub
		
	}
	
}
