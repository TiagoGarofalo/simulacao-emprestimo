package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import model.vo.VendedorVO;

public class VendedorDAO {

	VendedorVO vendedor = new VendedorVO();
	
	public boolean insert(VendedorVO vendedor) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO vendedor " + "(nome_vendedor, CPFVENDEDOR, email, senha) " + "VALUES (?, ?, ?, ?)");
			ps.setString(1, vendedor.getNome());
			ps.setString(2, vendedor.getCpf());
			ps.setString(3, vendedor.getEmail());
			ps.setString(4, vendedor.getSenha());

			ps.execute();
			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean update(VendedorVO vendedor) {

		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql = "UPDATE cliente SET nome = ?, email= ? WHERE ID_vendedor= ?";

			PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);

			ps.setString(1, vendedor.getNome());
			ps.setString(2, vendedor.getEmail());
			ps.setInt(3, vendedor.getId());

			ps.execute();

			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean salvar(VendedorVO vendedor) {
		if (vendedor.getId() != 0) {

			return update(vendedor);

		} else {
			return insert(vendedor);
		}
	}

	public boolean delete(String cpf) {

		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql = " DELETE FROM VENDEDOR  WHERE CPFVENDEDOR = ? ";

			PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);

			ps.setString(1, cpf);

			ps.execute();

			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}
	public boolean fazerLogin(String cpf , String senha) {
		
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM VENDEDOR WHERE CPFVENDEDOR=? AND SENHA=?");
			ps.setString(1, vendedor.getCpf());
			ps.setString(2, vendedor.getSenha());
		
			
			ps.execute();

			ps.close();
			conn.close();
			return true;
			
		} catch (SQLException e) {
			
		
				}
		return false;
		
		
	}
	

}
