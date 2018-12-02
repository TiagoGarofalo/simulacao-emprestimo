package model.bo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import model.vo.SimulacaoVO;


/**
 * Classe utilitária para gerar planilhas Excel através da API Apache POI.
 * 
 * @author Vilmar César Pereira Júnior
 *
 */
public class GeradorPlanilha {

	/**
	 * Gera uma planilha .xls de produtos (exemplo básico)
	 * 
	 * @param simulacoes
	 *            a lista de produtos que vai preencher a planilha
	 * 
	 * @return byte[] a planilha (do tipo HSSFWorkbook) convertida para um array
	 *         de bytes
	 * @throws FileNotFoundException 
	 */
	public void gerarPlanilhaProdutos(List<SimulacaoVO> simulacoes, String caminho) throws FileNotFoundException {
		PrintWriter pw;
		pw = new PrintWriter(new File(caminho + ".csv"));
	    StringBuilder sb = new StringBuilder();
	    addHeader(sb);
	    
	    for (SimulacaoVO simulacaoVO : simulacoes) {
	    	addRow(sb, simulacaoVO);
		}
	
	    pw.write(sb.toString());
	    pw.close();
		
		
//		String[] columns = { "Contrato", "Nome", "CPF", "Valor", "Validade" };
//
//		HSSFWorkbook planilha = new HSSFWorkbook();
//
//		// 1) Cria uma aba na planilha (nome é um parâmetro opcional)
//		HSSFSheet abaPlanilha = planilha.createSheet("Simulações");
//
//		Row headerRow = abaPlanilha.createRow(0);
//
//		// 2) Cria o cabeçalho a partir de um array columns
//		for (int i = 0; i < columns.length; i++) {
//			Cell cell = headerRow.createCell(i);
//			cell.setCellValue(columns[i]);
//		}
//
//		// 3) Cria as linhas com os produtos da lista
//		int rowNum = 1;
//		for (SimulacaoVO simul : simulacoes) {
//			Row novaLinha = abaPlanilha.createRow(rowNum++);
//			
//			novaLinha.createCell(0).setCellValue(simul.getNumero_Contrato());
//			novaLinha.createCell(1).setCellValue(simul.getNome_Cliente());
//			novaLinha.createCell(2).setCellValue(simul.getValor_contrato());
//	
//		}
//
//		// 4) Ajusta o tamanho de todas as colunas conforme a largura do
//		// conteúdo
//		for (int i = 0; i < columns.length; i++) {
//			abaPlanilha.autoSizeColumn(i);
//		}
//
//		//5) Escreve o arquivo em disco, no caminho informado
//		FileOutputStream fileOut = null;
//		try {
//			fileOut = new FileOutputStream(caminho + ".xls");
//			planilha.write(fileOut);
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			if(fileOut != null){
//				try {
//					fileOut.close();
//					planilha.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}

	private void addRow(StringBuilder sb, SimulacaoVO simulacaoVO) {
		sb.append(simulacaoVO.getNumero_Contrato());
	    sb.append(',');
	    sb.append(simulacaoVO.getNome_Cliente());
	    sb.append(',');
	    sb.append(simulacaoVO.getCpf_cliente());
	    sb.append(',');
	    sb.append(simulacaoVO.getValor_contrato());
	    sb.append(',');
	    sb.append(simulacaoVO.getNum_parcelas());
	    sb.append(',');
	    sb.append(simulacaoVO.getContratado());
	    sb.append('\n');
	}

	private void addHeader(StringBuilder sb) {
		sb.append("Contrato");
	    sb.append(',');
	    sb.append("Nome");
	    sb.append(",");
	    sb.append("CPF");
	    sb.append(",");
	    sb.append("Valor");
	    sb.append(",");
	    sb.append("num Parcelas");
	    sb.append(",");
	    sb.append("Contratado");
	    sb.append('\n');
	}
}