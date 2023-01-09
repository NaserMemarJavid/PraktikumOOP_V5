package gui.guiSportstaetten;
 
import java.io.IOException;

import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import gui.guiFreizeitbaeder.FreizeitbaederView;
import javafx.stage.Stage;
import ownUtil.PlausiException;

public class SportstaettenControl {
	 

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	
	public SportstaettenControl(Stage primaryStage) {
//		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederModel = freizeitbaederModel.getInstance();
		this.sporthallenModel = sporthallenModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, primaryStage, freizeitbaederModel, sporthallenModel );
	}

	public void leseSporthallenAusCsvDatei()  {
		try {
			sporthallenModel.leseSporthallenAusCsvDatei();
		} 
		catch(IOException exc){
			sportstaettenView.zeigeFehlermeldungAn("IOException beim Speichern!");
		}
		catch(Exception exc){
			sportstaettenView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
		}
		
	}

	public String zeigeSporthallenAn() {
		return sporthallenModel.zeigeSporthallenAn();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
