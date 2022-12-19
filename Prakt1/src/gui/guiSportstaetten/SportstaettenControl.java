package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import gui.guiFreizeitbaeder.FreizeitbaederView;
import javafx.stage.Stage;

public class SportstaettenControl {
	 

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	
	public SportstaettenControl(Stage primaryStage) {
//		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, primaryStage, freizeitbaederModel );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
