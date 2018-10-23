package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Banco;
import model.vo.Aluno;
import model.vo.Simulacao;

public class SimulacaoDAO {
	
	/**
	 * 
	 * @param a o novo aluno a ser salvo
	 * @return id caso positivo, é a chave gerada pelo SGBD
	 * 			  caso -1, houve erro no INSERT
	 */
	public int inserir(Simulacao a){
		int novoId = -1;
		//

		String sql = " INSERT INTO SIMULACAO (ID_SIMULACAO, CPF, ID_EMPRESTIMO, DATAINICIO,DATAFINAL, TXJUROS, QNTPARCELAS,VALORJUROS,VALOREMPRESTIMO) "
				+ " VALUES (?,?,?,?,?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, a.getIds_simulacao());
			prepStmt.setString(2, a.getCpf());
			prepStmt.setString(3, a.getEmprestimo());
			prepStmt.setDouble(4, a.getDataInicio());
			prepStmt.setInt(5, a.getDataFinal());
			prepStmt.setInt(6, a.getTxjuros());
			prepStmt.setInt(7, a.getQntParcelas());
			prepStmt.setInt(8, a.getValorJuros());
			prepStmt.setInt(9, a.getValorTotalEmprestimo());
			

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
	}

	public boolean atualizar(Simulacao a){
		boolean sucessoUpdate = false;

		String sql = " UPDATE SIMULACAO P SET NOME=?, SOBRENOME=?, MATRICULA=?, NOTA_P1=?, NOTA_P2=?"
				+ "NOTA_T1=?, NOTA_T2=?, PESO_PROVAS=?, PESO_TRABALHOS=?, NIVEL=?, SITUACAO=?, NOTA_FINAL=? "
				+ " WHERE P.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setInt(1, a.getIds_simulacao());
			prepStmt.setString(2, a.getCpf());
			prepStmt.setString(3, a.getEmprestimo());
			prepStmt.setDouble(4, a.getDataInicio());
			prepStmt.setInt(5, a.getDataFinal());
			prepStmt.setInt(6, a.getTxjuros());
			prepStmt.setInt(7, a.getQntParcelas());
			prepStmt.setInt(8, a.getValorJuros());
			prepStmt.setInt(9, a.getValorTotalEmprestimo());

			int codigoRetorno = prepStmt.executeUpdate();

			if(codigoRetorno == 1){
				sucessoUpdate = true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar aluno. Causa: \n:" + e.getCause());
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}

		return sucessoUpdate;
	}
	
	public boolean remover(int id){
		boolean sucessoDelete = false;

		String sql = " DELETE FROM ALUNO "
				+ " WHERE ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		try {
			prepStmt.setInt(1, id);
			int codigoRetorno = prepStmt.executeUpdate();
			if(codigoRetorno == 1){//1 - sucesso na execução
				sucessoDelete = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao remover aluno. Causa: \n:" + e.getCause());
		}finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return sucessoDelete;
	}
	
	public ArrayList<Aluno> listarTodos(){
		String sql = " SELECT * FROM ALUNO ";
		
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			ResultSet result = prepStmt.executeQuery();
			
			while(result.next()){
				Aluno aluno = new Aluno();
				
				aluno.setId(result.getInt("ID"));
				aluno.setNome(result.getString("NOME"));
				aluno.setMatricula(result.getString("MATRICULA"));
				aluno.setNotaProva1(result.getDouble("NOTA_P1"));
				aluno.setNotaProva2(result.getDouble("NOTA_P2"));
				
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			System.out.println("Erro listar todos os alunos. Causa: \n:" + e.getCause());
		}
		return alunos;
	}
	/**
	 * Retorna um produto dado um id.
	 * 
	 * @param id o identificador do produto
	 * @return um produto caso o id exista na tabela Produto
	 * 		   null caso contrário
	 */
	public Aluno obterPorId(int id){
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
	}
}