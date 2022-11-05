package gui;

import javafx.stage.*;
import ownUtil.PlausiException;

import java.io.IOException;

import business.FreizeitbaederModel;

public class FreizeitbaederControl{
	
	FreizeitbaederView freizeitbaederView;
	FreizeitbaederModel freizeitbaederModel;
	
	public FreizeitbaederControl( Stage primaryStage ) {
		
		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel );
		
	}

	public void nehmeFreizeitbadAuf(String name, String von, String bis, String laenge, String temp) {
		try{
			this.freizeitbaederModel.nehmeFreizeitbadAuf(name, von, bis, laenge, temp);
			this.freizeitbaederView.zeigeInformationsfensterAn("Der Text wurde in die Datei geschrieben.");
		} 
		catch(PlausiException exc) {
			this.freizeitbaederView.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
		}
		
	}

	public String zeigeFreizeitbadAn() {
		String txt="!!!!";
		try{
			txt = this.freizeitbaederModel.zeigeFreizeitbadAn();
		} 
		catch(PlausiException exc) {
			this.freizeitbaederView.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
		}
		return txt;
	}

	public void schreibeFreizeitbaederInDatei(String typ){
		try{
			if("csv".equals(typ)){
				// Aufruf des Models zum Schreiben des
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				// Freizeitbads in die Datei des vorgegebenen
				// Typs und Ausgabe der Meldung
			}
			else{
				freizeitbaederView.zeigeInformationsfensterAn(
				"Noch nicht implementiert!");
				}
		}
		catch(IOException exc){
			freizeitbaederView.zeigeFehlermeldungAn("IOException beim Speichern!");
		}
		catch(Exception exc){
			freizeitbaederView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
		}
	} 
		
		
}

































