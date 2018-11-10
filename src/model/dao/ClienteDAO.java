package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banco;
import model.vo.ClienteVO;

public class ClienteDAO {

	public static ClienteVO inserirCliente(ClienteVO cliente) {

		String sql = " INSERT INTO SIMULACAO (NOME, EMAIL, CPF,) "
				+ " VALUES (?,?,?) ";
		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
		try {
			prepStmt.setString(1, cliente.getNome());
			prepStmt.setString(2, cliente.getEmail());
			prepStmt.setInt(3, cliente.getCPf());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir cliente: \n:" + e.getMessage());
		} finally {
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return cliente;

	}
}