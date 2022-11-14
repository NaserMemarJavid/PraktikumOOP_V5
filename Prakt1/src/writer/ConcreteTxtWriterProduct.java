package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtWriterProduct extends WriterProduct {
	
	private BufferedWriter aus;
	public ConcreteTxtWriterProduct() throws IOException {
		this.aus = new BufferedWriter(
				new FileWriter("Freizeitbaeder.txt", true));
	}

	@Override
	public void fuegeInDateiHinZu(Freizeitbad freizeitbad) throws IOException {
		aus.write(
				"Daten des Freizeitbades"+
				"\n Name des Freizetbads: \t" + freizeitbad.getName() +
				"\n OefnungsZeit des Freizeitbads: \t"+ freizeitbad.getGeoeffnetVon()+"-"+ freizeitbad.getGeoeffnetBis() +
				"\n Beckenlaenge des Freizeitbads: \t"+ freizeitbad.getBeckenlaenge()+ 
				"\n Wassertemperatur des freizeitbades: \t"+ freizeitbad.getTemperatur() 
				);
		aus.newLine();
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		aus.flush();
		aus.close();
		
	}

}
