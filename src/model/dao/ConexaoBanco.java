package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {

	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static final String NOME_ESQUEMA = "SIMULAEMPRESTIMO";
	private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/" + NOME_ESQUEMA;
	private static final String USUARIO = "root";
	private static final String SENHA = "admin";

	/**
	 * Estabelece a conexão JBDC considerando as configurações da classe Banco.
	 * 
	 * @return Connection um objeto de conexão JDBC.
	 * 
	 * @throws ClassNotFoundException
	 *             caso o nome completo de DRIVER_MYSQL esteja incorreto ou o
	 *             driver JDBC do banco selecionado não foi adicionado ao
	 *             projeto (via .jar ou dependência no pom.xml).
	 * 
	 * @throws SQLException
	 *             caso a URL_CONEXAO, USUARIO e/ou SENHA estejam incorretos.
	 */
	public static Connection getConnection() {

		try {
			Connection conn = null;
			Class.forName(DRIVER_MYSQL);
			conn = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver n�o foi encontrada. \n" + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection.\n" + e.getMessage());
			return null;
		}
	}

	/**
	 * Fecha uma conexão informada pelo chamador.
	 * 
	 * @param conn o objeto do tipo Connection que deve ser fechado
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conexão.");
		}
	}

	public static Statement getStatement(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement.");
			return null;
		}
	}

	
	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement.");
		}
	}


	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}
	
	public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, tipoRetorno);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	/**
	 * 
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a execução da expressão
	 * SQL.
	 * 
	 * @param stmt um objeto do tipo PreparedStatement
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closePreparedStatement(PreparedStatement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement.");
		}
	}

	/**
	 * 
	 * Fecha um objeto ResultSet anteriormente criado.
	 * 
	 * Este método deve ser sempre chamado nos DAOs após a consulta de todos os
	 * resultados e conversão para objetos.
	 * 
	 * @param result um objeto do tipo ResultSet
	 * 
	 * @throws SQLException
	 * 
	 */
	public static void closeResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet");
		}
	}
}