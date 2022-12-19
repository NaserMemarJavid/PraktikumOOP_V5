package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvWriterProduct extends WriterProduct {
	
	private BufferedWriter aus;
	public ConcreteCsvWriterProduct() throws IOException {
		this.aus = new BufferedWriter(
				new FileWriter("Freizeitbaeder.csv", true));
	}
 
	@Override
	public void fuegeInDateiHinZu(Freizeitbad freizeitbad) throws IOException {

		aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		aus.newLine();
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		aus.flush();
		aus.close();
	}

	
	

}
