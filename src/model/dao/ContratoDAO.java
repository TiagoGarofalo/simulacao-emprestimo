package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.vo.ContratoVO;

public class ContratoDAO {

	public boolean salvarContrato(ContratoVO contrato) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn

					.prepareStatement(" INSERT INTO contrato (ID_CONTRATO,NUMERO_CONTRATO, VALOR_DO_CONTRATO, NUMERO_PARCELAS) "
							+ "VALUES ( ?, ?, ?, ?)" );
			ps.setInt(1, contrato.getId());
			ps.setString(2, contrato.getNumContrato());
			ps.setDouble(3, contrato.getValorContrato());
			ps.setInt(4, contrato.getNumParcela());

			ps.execute();
			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
