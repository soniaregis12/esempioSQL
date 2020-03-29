package it.polito.tdp.esempioSQLdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.esempioSQL.model.Station;

public class BabsDAO {
	
	public List<Station> listStation(){
		
		List<Station> listaStazioni = new LinkedList<Station>();
		
		String sql = "SELECT station_id, NAME ,dockcount, landmark FROM station ORDER BY name";
		
		try {
		
			Connection con = DBConnect.getConnection();
			
			PreparedStatement st = con.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name") , res.getInt("dockCount"), res.getString("landmark"));
				listaStazioni.add(s);
			}
			st.close();
	
			con.close();
	
			return listaStazioni;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Station> listStationByLandmark(String landmark){

		List<Station> listaStazioni = new LinkedList<Station>();
		
		String sql = "SELECT station_id, NAME ,dockcount, landmark FROM station  WHERE landmark=? ORDER BY name ";
		
		try {
		
			Connection con = DBConnect.getConnection();
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, landmark);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name") , res.getInt("dockCount"), res.getString("landmark"));
				listaStazioni.add(s);
			}
			st.close();
	
			con.close();
	
			return listaStazioni;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
