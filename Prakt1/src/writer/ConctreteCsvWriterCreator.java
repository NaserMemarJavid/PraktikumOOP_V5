package writer;

import java.io.IOException;

public class ConctreteCsvWriterCreator extends WriterCreator{

	@Override
	public WriterProduct factoryMethod() throws IOException {
		
		return new ConcreteCsvWriterProduct();
	}

} 
