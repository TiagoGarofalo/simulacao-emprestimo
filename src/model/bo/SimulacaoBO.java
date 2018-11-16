package model.bo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import model.dao.SimulacaoDAO;
import model.vo.SimulacaoVO;

public class SimulacaoBO {

	SimulacaoDAO dao = new SimulacaoDAO();
	
	public double calcularJuros(SimulacaoVO simula) {
		double juros = 0;
		double jurosP = 0;
		double jurosV = 0;
		if (simula.getValorCont() <= 1000) {
			jurosV = 1.8;
		} else {
			jurosV = 3;}
		
		if (simula.getNumParcela() > 12) {
			jurosP = 0.5;
		} else {
			jurosP = 0;}

		juros = jurosV + jurosP;
		return juros;
	}

	public double calcularValorParcelas(SimulacaoVO simula) {

		double juros = 0;
		double jurosP = 0;
		double jurosV = 0;
		if (simula.getValorCont() <= 1000) {
			jurosV = 1.8;
		} else {
			jurosV = 3;}
		
		if (simula.getNumParcela() > 12) {
			jurosP = 0.5;
		} else {
			jurosP = 0;}

		juros = jurosV + jurosP;
		
		double valorP = (simula.getValorCont() * (1+(simula.getNumParcela()*(juros/100))))/simula.getNumParcela();
		
		return valorP;
	}

	public boolean validaCPF(String cpf) {

		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11))
			return false;

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	public List<SimulacaoVO> listarSimulacoes(Long numContrato, String cpfCliente) {
		
		ArrayList<SimulacaoVO> simula = dao.listarPorNumContCpf(numContrato, cpfCliente);
		
		return simula;
	}

	public SimulacaoVO salvarSimulacao(SimulacaoVO s) {
		
		return dao.inserir(s);
	}
	
}
