package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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

	public boolean update(ClienteVO cliente) {
	
		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql ="UPDATE cliente SET nome = ?, email= ? WHERE CPFCLIENTE= ?";
			
			PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getCpf());

			ps.execute();

			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/*public boolean salvar(ClienteVO cliente) {
		if (cliente.getCpf() == cliente.getCpf()) {

			return update(cliente);

		} else {
			return insert(cliente);
		}
	}*/

	public boolean delete(String cpf) {
		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql = " DELETE FROM cliente WHERE CPFcliente = ? ";

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
	
	public boolean  verificaCfp(String cpf) {
		
		String sql = "SELECT COUNT(*) FROM CLIENTE WHERE CPFCLIENTE = ?";
		boolean cpfJaCadastrado = false;
		
		Connection conn = ConexaoBanco.getConnection();
		PreparedStatement stmt = ConexaoBanco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		try{
			stmt.setString(1, cpf);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				int quantidadeRegistros = resultado.getInt(1);
				cpfJaCadastrado = (quantidadeRegistros > 0);
			}
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao consultar o CPF = " + cpf);
		} finally {
			ConexaoBanco.closeResultSet(resultado);
			ConexaoBanco.closeStatement(stmt);
			ConexaoBanco.closeConnection(conn);
		}
		return cpfJaCadastrado;
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
