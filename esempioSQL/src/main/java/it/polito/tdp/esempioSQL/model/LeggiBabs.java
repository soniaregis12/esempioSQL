package it.polito.tdp.esempioSQL.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeggiBabs {

	public void run() {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=MuccaVolante98";
		
		try {
		
			Connection con = DriverManager.getConnection(jdbcURL);
			
			Statement st = con.createStatement();
			
			String sql = "SELECT NAME FROM STATION";
			
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String  nomeStazione = res.getString("name");
				
				System.out.println(nomeStazione);
			}
			st.close();
			
			Statement st2 = con.createStatement();
			// Non c'è bisogno che chiuda la connessione, devo chiudere lo statement prima di iniziarne un'altro
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// FACTORY creazione oggetto di una classe senza sapere il tipo della classe => non posso usare new
		// Uso allora un metodo fornito da un'altra classe che farà la new internamente e conoscerà il tipo di classe in questione
		
	}
	public static void main(String args[]) {
		LeggiBabs babs= new LeggiBabs();
		babs.run();
	}
}
