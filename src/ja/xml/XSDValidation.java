package ja.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidation {
	public static void main(String[] args) {
		File xmlFile = new File("resources\\studenti.xml");
		File xsdFile = new File("resources\\studenti.xsd");
		if (ValidateXML(xmlFile, xsdFile)) {
			System.out.println("Content is valid.");
		}
	}

	private static boolean ValidateXML(File xmlFile, File xsdFile) {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = factory.newSchema(xsdFile);
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(xmlFile));
			return true;
		} catch (SAXException e) {
			System.out.println("XML validation error!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
