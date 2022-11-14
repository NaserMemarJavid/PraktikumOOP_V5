package writer;

import java.io.IOException;

import business.Freizeitbad;

public abstract class WriterProduct {
	
	public abstract void fuegeInDateiHinZu(Freizeitbad freizeitbad) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;

}
