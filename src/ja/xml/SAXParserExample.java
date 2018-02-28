package ja.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXParserExample {

	public static void main(String[] args) {
		File file = new File("resources\\studenti.xml");
		parseFile(file);
	}

	private static void parseFile(File file) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);

		try {
			SAXParser parser = factory.newSAXParser();
				parser.parse(file, new SAXDefaultHandler());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
