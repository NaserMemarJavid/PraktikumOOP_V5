package gui.guiSportstaetten;

 
import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import gui.guiFreizeitbaeder.FreizeitbaederControl;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class SportstaettenView implements Observer{

	// Hier ergaenzen
	private SportstaettenControl sportstaettenControl;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;



	//---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new  Pane();

	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
	private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");

	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeSporthallen  = new TextArea();
	private Button btnAnzeigeSporthallen = new Button("CSV-Import und Anzeige");

	//-------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(SportstaettenControl sportstaettenControl,Stage primaryStage,
			FreizeitbaederModel frezeitbaederModel, SporthallenModel sporthalleModel){
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportstätten");
		primaryStage.show();
		// Hier ergaenzen
		this.sportstaettenControl = sportstaettenControl;
		this.freizeitbaederModel = frezeitbaederModel;
		this.sporthallenModel = sporthallenModel;

		this.freizeitbaederModel.addObserver(this);


		this.initKomponentenFreizeitbaeder();
		this.initKomponentenSporthallen();
		this.initListenerFreizeitbaeder();
		this.initListenerSporthallen();
	}
	private void initKomponentenFreizeitbaeder(){
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;"); 
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);    
		// Textbereich	
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);        	
		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder); 
	}
	private void initKomponentenSporthallen(){
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeSporthallen.setLayoutX(30);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
		pane.getChildren().add(lblAnzeigeSporthallen);    
		// Textbereich	
		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(30);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);        	
		// Button
		btnAnzeigeSporthallen.setLayoutX(30);
		btnAnzeigeSporthallen.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSporthallen); 
	}

	private void initListenerFreizeitbaeder() {
		btnAnzeigeFreizeitbaeder.setOnAction(
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						//zeigeFreizeitbadAn();
					} 
				});
	}

	private void initListenerSporthallen() {
		btnAnzeigeSporthallen.setOnAction( e-> {
			sportstaettenControl.leseSporthallenAusCsvDatei();
			this.txtAnzeigeSporthallen.setText( zeigeSporthallenAn() );
		});
	}

	private void zeigeFreizeitbaederAn(){
		if(freizeitbaederModel.getFreizeitbaeder().size() > 0){
			StringBuffer text = new StringBuffer();
			for(Freizeitbad fzb : freizeitbaederModel.getFreizeitbaeder() )
			{
				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
				//    				txtAnzeigeFreizeitbaeder.setText(
				//    	    				e.gibFreizeitbadZurueck(' '));
			}
			this.txtAnzeigeFreizeitbaeder.setText(text.toString());

		}
		else{
			zeigeInformationsfensterAn(
					"Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}
	
	private String zeigeSporthallenAn() {
		return sportstaettenControl.zeigeSporthallenAn();
	}

	private void zeigeInformationsfensterAn(String meldung){
		new MeldungsfensterAnzeiger(AlertType.INFORMATION,
				"Information", meldung).zeigeMeldungsfensterAn();
	}
	
	public void zeigeFehlermeldungAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR,
	    		"!!ACHTUNG!!", meldung).zeigeMeldungsfensterAn();
		
	}

	//Implementation des Interface-Observers
	@Override
	public void update() {
		zeigeFreizeitbaederAn();

	}	

}
