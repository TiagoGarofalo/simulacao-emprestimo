package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;


public class ClienteDAO {

	public boolean insert(ClienteVO cliente) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO cliente " + "(nome, cpfcliente, email) " + "VALUES ( ?, ?, ?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());

			ps.execute();
			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean update(ClienteVO cliente) {
	
		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql ="UPDATE cliente SET nome = ?, email= ? WHERE id_cliente= ?";
			
			PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setInt(3, cliente.getId());

			ps.execute();

			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean salvar(ClienteVO cliente) {
		if (cliente.getId() != 0) {

			return update(cliente);

		} else {
			return insert(cliente);
		}
	}

	public boolean delete(String cpf) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM cliente " + "WHERE cpf = ?");
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
	public ArrayList<ClienteVO> listarTodos() {
		
		String sql = "SELECT * FROM cliente;";
            
        Connection conn = ConexaoBanco.getConnection();
        PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);
        ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
        
        try {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ClienteVO cliente = new ClienteVO();
                cliente.setCpf(rs.getString("CPFCLIENTE"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                int idcliente= rs.getInt("id_cliente");
                
                clientes.add(cliente);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }
	/**public ClienteVO buscarPorcpf(int idcliente) {
        Connection conn = ConnectionManager.getConnection();
       ClienteVO listacliente = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT cpf, "+ "nome " + "FROM cliente WHERE cpf= ?");
            ps.setString(1, idcliente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                listacliente = new ClienteVO();
                listacliente.setCpf(rs.getString("cpf"));
                listacliente.setNome(rs.getString("nome"));
              

            }
            rs.close();
            ps.close();
            conn.close();
            return listacliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }*/
}
