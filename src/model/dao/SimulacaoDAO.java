package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Banco;
import model.vo.Simulacao;

public class SimulacaoDAO {
	
	/**
	* 
	* @param s o novo aluno a ser salvo
	* @return id caso positivo, é a chave gerada pelo SGBD
	* 			  caso -1, houve erro no INSERT
	*/
	public int inserir(Simulacao s){
		int novoId = -1;
		//

		String sql = " INSERT INTO SIMULACAO (NOME, EMAIL, CPF, DTSIMULACAO,VALORCONT, NUMPARCELA, NUNCONT,VALORPARCELA,DTVALIDADE) "
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
	}

	public boolean atualizar(Simulacao a){
		boolean sucessoUpdate = false;

		String sql = " UPDATE SIMULACAO P SET ID_SIMULACAO=?,EMAIL=?, CPF=?, DTSIMULACAO=?,VALORCONT=?, NUMPARCELA=?, NUNCONT=?,VALORPARCELA=?,DTVALIDADE=? "
				         + " WHERE P.ID = ? ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

		try {
			prepStmt.setString(1, a.getNome());
			prepStmt.setString(2, a.getEmail());
			prepStmt.setString(3, a.getCpf());		
			prepStmt.setDate(4, (Date) a.getDtsimulacao());
			prepStmt.setDouble(5, a.getValorCont());
			prepStmt.setDouble(6, a.getNumParcela());
			prepStmt.setLong(7, a.getNumCont());
			prepStmt.setDouble(8, a.getValorParcela());
			prepStmt.setDate(9, (Date) a.getDtValidade());
			
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

		String sql = " DELETE FROM SIMULACAO "
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