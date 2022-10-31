package gui;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ownUtil.PlausiException;

public class FreizeitbaederControl {
	
	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
		
		
	}

	public void nehmeFreizeitbadAuf(String name, String von, String bis, String laenge, String temp) {
		try{
    		this.freizeitbaederModel.nehmeFreizeitbadAuf(name, von, bis, laenge, temp);
    		this.freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
		
		catch(Exception exc){
			this.freizeitbaederView.zeigeFehlermeldungsfensterAn(" Fehler",
			"Fehler beim Schreiben in die Datei.");
     	}
		
	}

	public String zeigeFreizeitbaederAn() {
		String txt= " ";
		try{
    		txt = freizeitbaederModel.zeigeFreizeitbaederAn();
    		//this.freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
		
		catch(Exception exc){
			this.freizeitbaederView.zeigeFehlermeldungsfensterAn(" Fehler",
			"Fehler beim Schreiben in die Datei.");
     	}
		return txt;
	}
	
	
	
	
	
	
	
	
	
	/*
	
		public void schreibeInDatei(String text)
		throws Exception {
		BufferedWriter aus = new BufferedWriter(new FileWriter("Text.txt"));
		aus.write(text);
		aus.close();
		}
		}
		
		try{
			this.anwModel.schreibeInDatei(text);
			this.anwView.zeigeInformationsfensterAn(
			"Der Text wurde in die Datei geschrieben.");
			}
			catch(Exception exc){
			this.anwView.zeigeFehlermeldungAn(
			"Fehler beim Schreiben in die Datei.");
		*/
	
	

	

	


}
