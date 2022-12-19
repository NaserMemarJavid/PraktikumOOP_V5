package main;

import gui.guiFreizeitbaeder.FreizeitbaederControl;
import gui.guiSportstaetten.SportstaettenControl;
import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application{
	 
	@Override
	
	public void start(Stage primaryStage){
		
		//Fenster zu Freizeitbaeder
		new FreizeitbaederControl(primaryStage);
		
		//fenster zu Sportstaetten
		Stage fesnsterSportstaetten = new Stage();
		new SportstaettenControl(fesnsterSportstaetten);
		
	}
	

	public static void main( String[] args) {
		launch(args);
	
	}

	
	
}