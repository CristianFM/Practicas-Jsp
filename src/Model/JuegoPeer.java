package Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataBase.DataManager;
import Model.Juego;

public class JuegoPeer {

	public static boolean insertarJuego(String consola, String titulo, String genero, DataManager Datamanager) {
		
		Connection connection = Datamanager.getConnection();
		
		if (connection != null) {
			
			String query = "INSERT into juegos(id,consola,titulo,genero) Values(?,?,?,?)";
			
			try {
				PreparedStatement stm = (PreparedStatement) connection.prepareStatement(query);
				
				stm.setInt(1, 0);
				stm.setString(2, titulo);
				stm.setString(3, consola);
				stm.setString(4, genero);
				
				stm.executeUpdate();
				stm.close();
				connection.close();
				
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return false;
		}
	
	public static ArrayList<Juego> generarListaJuegos(DataManager Datamanager) {
		
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		Connection conn = Datamanager.getConnection();
		
		if(conn!=null) {
			String sql = "Select * From juegos";
			try {
				PreparedStatement stm = conn.prepareStatement(sql);
				
				ResultSet rs = stm.executeQuery(sql);
				
				Juego juego = null;
				
				while(rs.next()) {
					
					String consola = rs.getString("consola");
					String titulo = rs.getString("titulo");
					String genero = rs.getString("genero");
					
					juego = new Juego( titulo,consola,genero);
					
					juegos.add(juego);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return juegos;
	}
		
	}

