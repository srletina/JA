package ja.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParserExample {
	public static void main(String[] args) {
		boolean matBroj = false;
		boolean ime = false;
		boolean prezime = false;
		boolean godinaStudija = false;

		XMLInputFactory factory = XMLInputFactory.newFactory();
		try {
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("resources\\studenti.xml"));
			while (eventReader.hasNext()) {
				XMLEvent event = (XMLEvent) eventReader.next();

				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT: {
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					switch (qName) {
					case "student":
						System.out.println("Start element:" + qName);
						Iterator<?> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							System.out.println(attributes.next());
						}
						break;
					case "mat_broj":
						matBroj = true;
						break;
					case "ime":
						ime = true;
						break;
					case "prezime":
						prezime = true;
						break;
					case "godina_studija":
						godinaStudija = true;
						break;
					}
					break;
				}
				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (matBroj) {
						System.out.println("mat_broj:" + characters.getData());
					} else if (ime) {
						System.out.println("ime:" + characters.getData());
					} else if (prezime) {
						System.out.println("prezime:" + characters.getData());
					} else if (godinaStudija) {
						System.out.println("godinaStudija:" + characters.getData());
					}
					break;
				case XMLStreamConstants.END_ELEMENT: {
					EndElement endElement = event.asEndElement();
					String qName = endElement.getName().getLocalPart();
					switch (qName) {
					case "student":
						break;
					case "mat_broj":
						matBroj = false;
						break;
					case "ime":
						ime = false;
						break;
					case "prezime":
						prezime = false;
						break;
					case "godina_studija":
						godinaStudija = false;
						break;
					}
					break;
				}

				default:
					break;
				}

			}
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}
}
