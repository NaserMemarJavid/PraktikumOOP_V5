package business.businessFreizeitbaeder;
 
import java.io.BufferedWriter; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import ownUtil.PlausiException;
import writer.ConctreteCsvWriterCreator;
import writer.ConcreteTxtWriterCreator;
import writer.WriterCreator;
import writer.WriterProduct;

public class FreizeitbaederModel implements Observable{
	
	//private Freizeitbad freizeitbad;
	//P4
	private ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<>();
	//-------
	
	// Observersliste
	private Vector<Observer> observers = new Vector<Observer>();
	
	//Singleton Implementierung
	private static FreizeitbaederModel freizeitbaederModelInstance;
	private  FreizeitbaederModel(){}
	public static FreizeitbaederModel getInstance() {
		if( freizeitbaederModelInstance == null) {
			freizeitbaederModelInstance = new FreizeitbaederModel();
		}
		return freizeitbaederModelInstance;
	}
	//-----------------------------------------------------------------
	


	//p4
	public ArrayList<Freizeitbad> getFreizeitbaeder() {
		return this.freizeitbaeder;
	}
	
	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbaeder.add(freizeitbad);
		notifyObservers();
	}
	//---------
	
	
	
	public void nehmeFreizeitbadAuf(
			String name, String von, String bis, String laenge, String temp)
					throws PlausiException {
		addFreizeitbad(new Freizeitbad(name, von, bis, laenge, temp));
		notifyObservers();
	}

	public String zeigeFreizeitbaederAn () throws PlausiException {
		String text = " ";
		for(Freizeitbad e : this.freizeitbaeder) {
			text = text + e.gibFreizeitbadZurueck(' ') + "\n";
		}
		return text;
		
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
		
		for( Freizeitbad e : getFreizeitbaeder()) {

			writer.fuegeInDateiHinZu(e);
		}
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		WriterCreator writerCreator = new ConcreteTxtWriterCreator();
		WriterProduct writer = writerCreator.factoryMethod();
		
		for( Freizeitbad e : getFreizeitbaeder()) {

			writer.fuegeInDateiHinZu(e);
		}
		writer.schliesseDatei();
		
	}
	
	// Methoden von Observable implementiert-----------------------------------
	@Override
	public void addObserver(Observer obs) {
		this.observers.addElement(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		this.observers.removeElement(obs);
		
	}
	@Override
	public void notifyObservers() {
		for(int i=0; i<this.observers.size(); i++) {
			this.observers.elementAt(i).update();
		}
		
	}
	//-------------------------------------------------------------------------

	
	
}




