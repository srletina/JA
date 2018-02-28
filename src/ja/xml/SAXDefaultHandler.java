package ja.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;;

public class SAXDefaultHandler extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start document");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End document");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Element start:");
		System.out.println("\tqname " + qName);
		if (attributes.getLength() > 0) {
			System.out.println("\tAttributes:");
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.println("\t\tqname:" + attributes.getQName(i));
				System.out.println("\t\tvaluee:" + attributes.getValue(i));

			}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("\tText: " + new String(ch, start, length));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("Element end:");
		System.out.println("\tqname:" + qName);
	}
}
