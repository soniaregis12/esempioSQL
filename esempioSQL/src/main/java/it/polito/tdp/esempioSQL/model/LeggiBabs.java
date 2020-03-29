package it.polito.tdp.esempioSQL.model;

import it.polito.tdp.esempioSQLdb.BabsDAO;
import java.util.*;

public class LeggiBabs {

	public void run() {
		
		BabsDAO dao = new BabsDAO();
		
		List<Station> tutte = dao.listStation();
		
		for(Station s : tutte) {
			System.out.println(s.getName());
		}
		
		System.out.println("---------------------------------------------------");
		
		List<Station> paloAlto = dao.listStationByLandmark("Palo Alto");
		
		for(Station p : paloAlto) {
			System.out.println(p.getName());
		}
	}
	public static void main(String args[]) {
		LeggiBabs babs= new LeggiBabs();
		babs.run();
	}
}
