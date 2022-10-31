package business;

import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ownUtil.PlausiException;

public class FreizeitbaederModel {
	
	// speichert temporaer ein Objekt vom Typ Freizeitbad
    private Freizeitbad freizeitbad;
	
	public FreizeitbaederModel()
	{
		
	}

	public void nehmeFreizeitbadAuf(String name, String von, String bis, String laenge, String temp) throws Exception {
		
		this.freizeitbad = new Freizeitbad(name, von, bis, laenge, temp);
	}

public String zeigeFreizeitbaederAn()  throws Exception {
	String txt = this.freizeitbad.gibFreizeitbadZurueck(' ');
	return txt;
		
		
	}

/*
	public void schreibeFreizeitbaederInCsvDatei()// Werfe IOException 
	{
		try {
			if("csv".equals(typ)) {
				//Aufruf model zum schreiben
				//freizeitbads in die datei vergeben
				//type und ausgabe der Meldung
			}
		}
		catch(IOException exc) {
			freizeitbaederView.zeigeInformationsfensterAn("noch nicht implementiert!");
		}
	}
	*/





}


