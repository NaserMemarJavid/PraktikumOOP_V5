package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ownUtil.PlausiException;
import writer.ConctreteCsvWriterCreator;
import writer.ConcreteTxtWriterCreator;
import writer.WriterCreator;
import writer.WriterProduct;

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
	/*
	public void schreibeFreizeitbaederInCsvDatei() 
	// Werfen einer IOException
			throws IOException{
		BufferedWriter aus = new BufferedWriter(
		new FileWriter("Freizeitbaeder.csv", true));
		aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();
	}*/
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		
		WriterCreator writerCreator = new ConctreteCsvWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		
		writer.fuegeInDateiHinZu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		WriterCreator writerCreator = new ConcreteTxtWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		
		writer.fuegeInDateiHinZu(this.freizeitbad);
		writer.schliesseDatei();
		
	}

	private Freizeitbad getFreizeitbad() {
		// TODO Auto-generated method stub
		return this.freizeitbad;
	}

	
	
}




