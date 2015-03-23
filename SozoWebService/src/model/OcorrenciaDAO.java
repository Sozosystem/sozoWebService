package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;



public class OcorrenciaDAO {
	
	public boolean salvar(Ocorrencia ocorrencia) {
		
		try {
			Connection conn = ConectarDB.getConexao();
			
			String query = "INSERT INTO ocorrencia VALUES (null, ?, null, null, null, null, ?, ?, null, null, 'PENDENTE')";
			PreparedStatement ps = conn.prepareStatement(query);
			java.util.Date date= new java.util.Date();
			ps.setTimestamp(1, new Timestamp(date.getTime()));
			
			ps.setDouble(2, ocorrencia.getLatitude());
			ps.setDouble(3, ocorrencia.getLongitude());
			
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
