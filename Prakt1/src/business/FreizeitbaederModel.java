package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import ownUtil.Observable;
import ownUtil.Observer;
import ownUtil.PlausiException;
import writer.ConctreteCsvWriterCreator;
import writer.ConcreteTxtWriterCreator;
import writer.WriterCreator;
import writer.WriterProduct;

public class FreizeitbaederModel implements Observable{
	
	private Freizeitbad freizeitbad;
	
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
	
	public void nehmeFreizeitbadAuf(
			String name, String von, String bis, String laenge, String temp)
					throws PlausiException {
		freizeitbad = new Freizeitbad(name, von, bis, laenge, temp);
		notifyObservers();
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

	public Freizeitbad getFreizeitbad() {
		// TODO Auto-generated method stub
		return this.freizeitbad;
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




