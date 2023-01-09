package business.businessSporthallen;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ownUtil.Observable;
import ownUtil.Observer;
import ownUtil.PlausiException;

public class SporthallenModel {
	
	private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
	
	private static SporthallenModel sporthallenModelInstance;
	private SporthallenModel() {}
	public static SporthallenModel getInstance() {
		if(sporthallenModelInstance == null) {
			sporthallenModelInstance = new SporthallenModel();
		}
		return sporthallenModelInstance;
		
	}
	
	
	public void leseSporthallenAusCsvDatei() throws IOException, PlausiException{
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
		String zeileStr = ein.readLine();
		while(zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add( 
					new Sporthalle(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}    
		ein.close();
		this.sporthallen = ergebnis;
	}
	
	public String zeigeSporthallenAn() {
		String text = "";
		for( Sporthalle e : sporthallen) {
			text += e.gibSporthalleZurueck(' ') + "\n";
		}
		return text;
	}

	

	

}
