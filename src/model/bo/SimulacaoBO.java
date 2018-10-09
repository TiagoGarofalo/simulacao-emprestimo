package model.bo;

import model.vo.Simulacao;

public class SimulacaoBO {

	public double calcularJuros(Simulacao simula) {
		double juros = 0;
		double jurosP = 0;
		double jurosV = 0;
		if (simula.getValorContrato() <= 1000) {
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

	public double calcularValorParcelas(Simulacao simula) {

		double juros = 0;
		double jurosP = 0;
		double jurosV = 0;
		if (simula.getValorContrato() <= 1000) {
			jurosV = 1.8;
		} else {
			jurosV = 3;}
		
		if (simula.getNumParcela() > 12) {
			jurosP = 0.5;
		} else {
			jurosP = 0;}

		juros = jurosV + jurosP;
		
		double valorP = (simula.getValorContrato() * (1+(simula.getNumParcela()*(juros/100))))/simula.getNumParcela();
		
		return valorP;
	}

}
