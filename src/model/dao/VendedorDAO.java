package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import model.vo.ClienteVO;
import model.vo.VendedorVO;

public class VendedorDAO {

	VendedorVO vendedor = new VendedorVO();

	public boolean insert(VendedorVO vendedor) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO vendedor " + "(nome_vendedor, CPFVENDEDOR, email, senha) " + "VALUES (?, ?, ?, ?)");
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

	public boolean fazerLogin(String nome, String senha) {

		Connection conn = ConexaoBanco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement("SELECT * FROM VENDEDOR WHERE NOME_VENDEDOR = ? and senha = ? ");
			stmt.setString(1, nome);
			stmt.setString(2, senha);

			rs = stmt.executeQuery();

			if (rs.next()) {
				return true;

			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return true;

		}

	}

	public ArrayList<VendedorVO> listarTodos() {
		String sql = "SELECT * FROM vendedor;";
        
        Connection conn = ConexaoBanco.getConnection();
        PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);
        ArrayList<VendedorVO> vendedores = new ArrayList<VendedorVO>();
        
        try {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                VendedorVO vendedor = new VendedorVO();
                vendedor.setCpf(rs.getString("CPFVENDEDOR"));
                vendedor.setNome(rs.getString("NOME_VENDEDOR"));
                vendedor.setEmail(rs.getString("email"));
                int ID_VENDEDOR = rs.getInt("ID_VENDEDOR");
                
              vendedores.add(vendedor);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendedores;
	}

	public Object verificarexist(VendedorVO novoVendedor) {
		Connection conn = ConexaoBanco.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement("SELECT * FROM VENDEDOR WHERE cpfvendedor =? ");
			stmt.setString(1, novoVendedor.getCpf());
			

			rs = stmt.executeQuery();

			if (rs.next()) {
				return false;

			}else {
				
				return false;
			}

			

		} catch (SQLException e) {
			e.printStackTrace();

			return false;

		}
	}
}
