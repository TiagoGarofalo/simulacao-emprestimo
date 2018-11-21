package model.controller;

import java.util.List;

import model.bo.SimulacaoBO;
import model.vo.ClienteVO;
import model.vo.ContratoVO;
import model.vo.SimulacaoVO;
import model.vo.VendedorVO;

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

	public SimulacaoVO salvarSimula(SimulacaoVO s,ClienteVO c,VendedorVO v,ContratoVO contrato) {

		return bo.salvarSimulacao(s,c,v,contrato);

	}

}
