package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ownUtil.PlausiException;

public class FreizeitbaederModel{
	
	private Freizeitbad freizeitbad;
	
	public  FreizeitbaederModel(){
		
	}
	
	public void nehmeFreizeitbadAuf(
			String name, String von, String bis, String laenge, String temp)
					throws PlausiException {
		freizeitbad = new Freizeitbad(name, von, bis, laenge, temp);
	}

	public String zeigeFreizeitbadAn () throws PlausiException {
		return this.freizeitbad.gibFreizeitbadZurueck(' ');
		
	}
	
	//---------------------------------------------------------
	public void schreibeFreizeitbaederInCsvDatei() 
	// Werfen einer IOException
			throws IOException{
		BufferedWriter aus = new BufferedWriter(
		new FileWriter("Freizeitbaeder.csv", true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();
	}

	private Freizeitbad getFreizeitbad() {
		// TODO Auto-generated method stub
		return this.freizeitbad;
	}
	
}




