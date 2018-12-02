package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.ConexaoBanco;
import model.vo.SimulacaoVO;
import model.vo.ContratoVO;
import model.vo.VendedorVO;
import model.vo.ClienteVO;

public class SimulacaoDAO {
	
	/**
	* 
	* @param s o novo aluno a ser salvo
	* @return id caso positivo, é a chave gerada pelo SGBD
	* 			  caso -1, houve erro no INSERT
	*/
	public SimulacaoVO inserir(SimulacaoVO simulacao,ClienteVO cliente,ContratoVO contrato){
		
				
		
		
	        String sql = " INSERT INTO SIMULACAO (nome_cliente,numero_contrato,valor_parcela,num_parcelas,valor_contrato,taxa_juros,valo_total_contrato,cpf_cliente, contratado, DT_INICIO, DT_FINAL) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	        Connection conexao = ConexaoBanco.getConnection();
			PreparedStatement prepStmt = ConexaoBanco.getPreparedStatement(conexao, sql);
			try {
				prepStmt.setString(1, cliente.getNome());
			//prepStmt.setString(2, vendedor.getNome());
				prepStmt.setString(2, contrato.getNumContrato());
				prepStmt.setDouble(3, simulacao.getValor_parcela());
				prepStmt.setDouble(4, simulacao.getNum_parcelas());
				prepStmt.setDouble(5, simulacao.getValor_contrato());
				prepStmt.setDouble(6, simulacao.getTaxa_juros());
				prepStmt.setDouble(7, simulacao.getValor_Total_Contrato());
				prepStmt.setString(8, cliente.getCpf());
				prepStmt.setString(9, simulacao.getContratado());
				prepStmt.setString(10, simulacao.getDt_inicio());
				prepStmt.setString(11, simulacao.getDt_final());
						
				//TODO preencher o restante
		
				prepStmt.execute();
		
			} catch (SQLException e) {
				System.out.println("ao salar simulacao: \n:" + e.getMessage());
			} finally{
				ConexaoBanco.closePreparedStatement(prepStmt);
				ConexaoBanco.closeConnection(conexao);
			}
	    return simulacao;
}
	
	/***	int novoId = -1;
		//

		String sql = " INSERT INTO SIMULACAO (NOME, EMAIL, CPF, DTSIMULACAO,
		VALORCONT, NUMPARCELA, NUNCONT,
		VALORPARCELA,DTVALIDADE) "
				+ " VALUES (?,?,?,?,?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, s.getNome());
			prepStmt.setString(2, s.getEmail());
			prepStmt.setString(3, s.getCpf());		
			prepStmt.setDate(4, (Date) s.getDtsimulacao());
			prepStmt.setDouble(5, s.getValorCont());
			prepStmt.setDouble(6, s.getNumParcela());
			prepStmt.setLong(7, s.getNumCont());
			prepStmt.setDouble(8, s.getValorParcela());
			prepStmt.setDate(9, (Date) s.getDtValidade());
			//TODO preencher o restante
			
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				novoId = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir aluno. Causa: \n:" + e.getMessage());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return novoId;
	}***/

	public boolean atualizar(SimulacaoVO simulacao,ClienteVO cliente,ContratoVO contrato){
		boolean sucessoUpdate = false;

		String sql = " UPDATE SIMULACAO P SET ID_SIMULACAO=?,EMAIL=?, CPF=?, "
				+ "DTSIMULACAO=?,VALORCONT=?, NUMPARCELA=?, NUNCONT=?,"
				+ "VALORPARCELA=?,DTVALIDADE=? "
				         + " WHERE P.ID = ? ";

		Connection conexao = ConexaoBanco.getConnection();
		PreparedStatement prepStmt = ConexaoBanco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, cliente.getNome());
			//prepStmt.setString(2, vendedor.getNome());
			prepStmt.setString(3, contrato.getNumContrato());
			//	prepStmt.setDate(4, new Date(simulacao.getDt_inicio().getTime()));
			//prepStmt.setDate(5, new Date(simulacao.getDt_final().getTime()));
			prepStmt.setDouble(6, simulacao.getValor_parcela());
			prepStmt.setDouble(7, simulacao.getNum_parcelas());
			prepStmt.setDouble(8, simulacao.getValor_contrato());
			prepStmt.setDouble(9,simulacao.getTaxa_juros());
			prepStmt.setDouble(10,simulacao.getValor_Total_Contrato());
			
			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar aluno. Causa: \n:" + e.getCause());
		}finally{
			ConexaoBanco.closePreparedStatement(prepStmt);
			ConexaoBanco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}
	
	public boolean remover(int id){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM SIMULACAO "
				+ " WHERE ID = ? ";

		Connection conexao = ConexaoBanco.getConnection();
		PreparedStatement prepStmt = ConexaoBanco.getPreparedStatement(conexao, sql);
		try {
			prepStmt.setInt(1, id);
			int codigoRetorno = prepStmt.executeUpdate();
			if(codigoRetorno == 1){//1 - sucesso na execução
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao remover aluno. Causa: \n:" + e.getCause());
		}finally{
			ConexaoBanco.closePreparedStatement(prepStmt);
			ConexaoBanco.closeConnection(conexao);
		}
		return sucessoDelete;
	}

	public ArrayList<SimulacaoVO> listarPorNumContCpf(String numContrato, String cpfCliente) {
		String parametros = "";
		
		if (!numContrato.isEmpty()) {
			parametros += "NUMERO_CONTRATO = ?";
		}
		
		if (!cpfCliente.isEmpty()) {
			if (!parametros.isEmpty()) {
				parametros += " and ";
			}
			parametros += "CPF_CLIENTE = ?";
		}
		
		String where = "";
		if (!parametros.isEmpty()) {
			where += " WHERE " + parametros;
		}
		
		String query = " SELECT * FROM SIMULACAO" + where;
		
		/*String query = ("select * from simulacao T0 inner join cliente T1 on T1.CPF_CLIENTE=T0.CPF_CLIENTE "
				+ "where (T0.ID_CONTRATO = IFNULL("+ numContrato +", ' ') OR IFNULL("+ numContrato +", ' ') = ' ') AND "
				+ "(T1.CPF_CLIENTE = IFNULL("+ cpfCliente +",' ') OR IFNULL("+ cpfCliente +",' ')=' ')");*/
		
		Connection conexao = ConexaoBanco.getConnection();
		PreparedStatement prepStmt = ConexaoBanco.getPreparedStatement(conexao, query);
		ArrayList<SimulacaoVO> simulacoes = new ArrayList<SimulacaoVO>();
		
		try {
			int index = 0;
			
			if (!numContrato.isEmpty()) {
				index++;
				prepStmt.setString(index, numContrato);
			}
			if (!cpfCliente.isEmpty()) {
				index++;
				prepStmt.setString(index, cpfCliente);
			}
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				SimulacaoVO s = new SimulacaoVO();
				
				//Obtendo valores pelo NOME DA COLUNA
			
						
				s.setNumero_Contrato(result.getString("NUMERO_CONTRATO"));
				s.setNome_Cliente(result.getString("NOME_CLIENTE"));
				s.setCpf_cliente(result.getString("CPF_CLIENTE"));
				s.setValor_contrato(result.getDouble("VALOR_CONTRATO"));
				s.setNum_parcelas(result.getInt("NUM_PARCELAS"));
				s.setContratado(result.getString("CONTRATADO"));
				simulacoes.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*if(numContrato!=null) {
			query+="and T0.NUMERO_CONTRATO = ?";
		}
		
		//TODO verificar se string nao eh nulo
		if(cpfCliente!=null) {
			query+="and T1.CPF_CLIENTE = ?";
		}*/
		
		return simulacoes;
	}
	
	public int BuscarProximoId() {
		int id=0;
		String sql = "SELECT ifnull(max(ID_SIMULACAO),0) + 1 as 'next' FROM SIMULACAO";
        
        Connection conn = ConexaoBanco.getConnection();
        PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);
        
        try {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                id =rs.getInt("next");
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
	}

	public void contrataEmprestimo(String numContrato) {
		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql ="UPDATE simulacao SET contratado = ? where numero_contrato = ?";
			
			PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);
			
			ps.setString(1, "Sim");
			ps.setString(2, numContrato);

			ps.execute();

			ps.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	/*public ArrayList<Simulacao> listarTodos(){
		String sql = " SELECT * FROM SIMULACAO ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Simulacao> alunos = new ArrayList<Simulacao>();
		
		try {
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				Simulacao simulacao = new  Simulacao();
				
				simulacao.setId(result.getInt("ID"));
				simulacao.setNome(result.getString("CPF"));
				simulacao.setMatricula(result.getString("EMPRESTIMO"));
				simulacao.setNotaProva1(result.getDouble("NOTA_P1"));
				simulacao.setNotaProva2(result.getDouble("NOTA_P2"));
				
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			System.out.println("Erro listar todos os alunos. Causa: \n:" + e.getCause());
		}
		return alunos;
	}*/
	/**
	* Retorna um produto dado um id.
	* 
	* @param id o identificador do produto
	* @return um produto caso o id exista na tabela Produto
	* 		   null caso contrário
	*/
	/*public Aluno obterPorId(int id){
		String sql = " SELECT * FROM ALUNO "
				+ " WHERE ID=?";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		Aluno aluno = null;
		
		try {
			prepStmt.setInt(1, id);
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				aluno = new Aluno();
				
				aluno.setId(result.getInt("ID"));
				aluno.setNome(result.getString("NOME"));
				aluno.setMatricula(result.getString("MATRICULA"));
				aluno.setNotaProva1(result.getDouble("NOTA_P1"));
				aluno.setNotaProva2(result.getDouble("NOTA_P2"));
			}
		} catch (SQLException e) {
			System.out.println("Erro buscar um aluno. Causa: \n:" + e.getCause());
		}
		return aluno;
	}*/
}